package spittr.data;

import spittr.Spittle;

import java.util.List;

/**
 * Created by wusj on 2017/11/26.
 */
public interface SpittleRepository {

    List<Spittle> findRecentSpittles();

    /**
     *
     *获取用户发布的消息
     * @param max 所返回的Spittle ID属性的最大值
     * @param count 返回多少个Spittle对象
     * @return
     */
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long id);

    void save(Spittle spittle);
}
