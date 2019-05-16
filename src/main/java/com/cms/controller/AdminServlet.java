package com.cms.controller;

import com.cms.mapper.AthleteMapper;
import com.cms.mapper.GameMapper;
import com.cms.mapper.RefereeMapper;
import com.cms.mapper.TeamMapper;
import com.cms.pojo.Athlete;
import com.cms.pojo.Game;
import com.cms.pojo.Team;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

public class AdminServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=UTF-8";
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        SqlSession sqlSession = MybatiesUtil.getSession();
        String method = request.getParameter("method");
        try {
            switch (method) {
                case "queryTeam": {
                    TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
                    String option = request.getParameter("select");
                    String input = request.getParameter("input");
                    List<Team> teams;
                    switch (option) {
                        case "all":
                            teams = mapper.queryAll();
                            request.setAttribute("teams", teams);
                            break;
                        case "tNo":
                            teams = mapper.queryByMyId(Integer.valueOf(input));
                            request.setAttribute("teams", teams);
                            break;
                        case "name":
                            teams = mapper.queryByName(input);
                            request.setAttribute("teams", teams);
                            break;
                    }
                    request.getRequestDispatcher("/team.jsp").forward(request, response);
                    break;
                }
                case "queryAthlete": {
                    AthleteMapper mapper = sqlSession.getMapper(AthleteMapper.class);
                    List<Athlete> athletes = mapper.queryAll();
                    request.setAttribute("athletes", athletes);
                    request.getRequestDispatcher("/athlete.jsp").forward(request, response);
                    break;
                }
                case "addTeam": {
                    Team team = new Team();
                    team.settNo(Integer.valueOf(request.getParameter("tno")));
                    team.setName(request.getParameter("name"));
                    team.setAccount(request.getParameter("account"));
                    team.setPassword(request.getParameter("password"));
                    TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
                    if (mapper.queryById(team.gettNo()) != null) {
                        out.print("<script>alert('队号重复,添加失败');window.location.href = 'http://localhost:8080/cms/teamAccount.jsp'</script>");

                    } else if (mapper.queryByAccount(team.getAccount()) != null) {
                        out.print("<script>alert('帐号重复,添加失败');window.location.href = 'http://localhost:8080/cms/teamAccount.jsp'</script>");
                    } else {
                        mapper.insert(team);
                        sqlSession.commit();
                        out.print("<script>alert('添加成功');window.location.href = 'http://localhost:8080/cms/teamAccount.jsp'</script>");
                    }
                    break;
                }
                case "delTeam": {
                    int tNo = Integer.valueOf(request.getParameter("teamNo"));
                    TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
                    teamMapper.deleteByTNo(tNo);
                    sqlSession.commit();
                    List<Team> teams = teamMapper.queryAll();
                    request.setAttribute("teams", teams);
                    request.getRequestDispatcher("/team.jsp").forward(request, response);
                    break;
                }
                case "updateTeam": {
                    String teamJson = request.getParameter("teamJson");
                    System.out.println(teamJson);
                    JSONObject jsonObject = new JSONObject(teamJson);
                    TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
                    Team team = teamMapper.queryById(jsonObject.getInt("tNo"));
                    team.setName(jsonObject.getString("name"));
                    team.setPassword(jsonObject.getString("password"));
                    teamMapper.updateNameAndPassword(team);
                    sqlSession.commit();
                    List<Team> teams = teamMapper.queryAll();
                    request.setAttribute("teams", teams);
                    request.getRequestDispatcher("/team.jsp").forward(request, response);
                    break;
                }
                case "delAthlete": {
                    String id = request.getParameter("athleteID");
                    AthleteMapper mapper = sqlSession.getMapper(AthleteMapper.class);
                    mapper.deleteByIdNum(id);
                    sqlSession.commit();
                    List<Athlete> athletes = mapper.queryAll();
                    request.setAttribute("athletes", athletes);
                    request.getRequestDispatcher("/athlete.jsp").forward(request, response);
                    break;
                }
                case "queryGame": {
                    GameMapper mapper = sqlSession.getMapper(GameMapper.class);
                    List<HashMap> hashMaps = mapper.queryAll();
                    JSONArray jsonArray = new JSONArray(hashMaps);
                    String head = "{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":";
                    String json = head + jsonArray + "}";
                    out.print(json);
                    out.flush();
                    out.close();
                    break;
                }
                case "addReferee": {
                    String gameJson = request.getParameter("gameJson");
                    JSONObject jsonObject = new JSONObject(gameJson);
                    GameMapper mapper = sqlSession.getMapper(GameMapper.class);
                    RefereeMapper rmapper = sqlSession.getMapper(RefereeMapper.class);
                    int id = jsonObject.getInt("GAMEID");
                    Game game = mapper.queryById(id);
                    if (!jsonObject.has("REFEREENUM")) {
                        out.print("<script>alert('请填写裁判编号');window.location.href = 'http://localhost:8080/cms/gameManage.jsp'</script>");
                    } else {
                        String rid = jsonObject.getString("REFEREENUM");
                        if (rmapper.queryById(rid) != null) {
                            game.setrIdNum(rid);
                            mapper.updateRId(game);
                            sqlSession.commit();
                            response.sendRedirect("/cms/gameManage.jsp");
                        } else {
                            out.print("<script>alert('未查询到此裁判编号');window.location.href = 'http://localhost:8080/cms/gameManage.jsp'</script>");
                        }
                    }
                    break;
                }

            }
        } catch (BindingException e) {
            sqlSession.rollback();
            out.print("<script>alert('错误!')</script>");
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        response.setContentType(CONTENT_TYPE);
    }
}