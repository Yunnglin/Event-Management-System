package com.cms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.GroupMapper;
import com.cms.mapper.ParticipationMapper;
import com.cms.mapper.RefereeSeviceMapper;
import com.cms.pojo.Athlete;
import com.cms.pojo.Game;
import com.cms.pojo.Participation;
import com.cms.pojo.Referee;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

public class Test2 {

    @Test
    public void t1(){
        SqlSession sqlSession = MybatiesUtil.getSession();
        RefereeSeviceMapper mapper = sqlSession.getMapper(RefereeSeviceMapper.class);
        List<Referee> referees = mapper.queryRelatedReferee(1);
        System.out.println(referees.size());
        for(int i=0; i<referees.size(); i++){
            System.out.println(referees.get(i).getIdNum());
        }
    }

    @Test
    public void t2(){
        Game game = new Game();
        game.setGameId(2);

        SqlSession sqlSession = MybatiesUtil.getSession();
        ParticipationMapper mapper = sqlSession.getMapper(ParticipationMapper.class);
        List<Athlete> athletes = mapper.queryAthletesByGame(game);
        System.out.println(athletes.size());
        for(int i=0; i<athletes.size(); i++){
            System.out.println(athletes.get(i).getName());
        }
        List<Participation> participations = mapper.queryParticipationByGame(game);
        System.out.println(participations.size());
        for(int i=0; i<participations.size(); i++){
            System.out.println(participations.get(i).getAthleteNo());
        }
    }

    @Test
    public void t3(){
        Game game = new Game();
        game.setGameId(1);

        SqlSession sqlSession = MybatiesUtil.getSession();
        GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
        List<Athlete> athletes = groupMapper.queryAthletesOrdered(game);
        for(int i=0; i<athletes.size(); i++){
            System.out.println(athletes.get(i).getNo() + ": " + athletes.get(i).getName());
        }
        sqlSession.close();
    }

    @Test
    public void t4(){
        Game game = new Game();
        game.setGameId(2);

        SqlSession sqlSession = MybatiesUtil.getSession();
        ParticipationMapper mapper = sqlSession.getMapper(ParticipationMapper.class);
        List<Participation> participations = mapper.queryParticipationByGame(game);
        System.out.println(participations.size());
        for(int i=0; i<participations.size(); i++){
            System.out.println(participations.get(i).getAthleteNo());
        }

        mapper.updateScores(participations.get(1));
        sqlSession.commit();
        System.out.println(JSON.toJSONString(participations.get(0)));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hhh", 2);
        System.out.println("get double: "+jsonObject.getDouble("hhh"));
    }
}
