package com.cms;

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
}
