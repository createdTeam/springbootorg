package mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * 继承自己的 通用MyMapper
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

    /**
     * 批量插入（所有字段） 与 insertList的不同
     * 非自增自定义ID场景使用
     *
     * @param recordList
     * @return
     */
    @org.apache.ibatis.annotations.InsertProvider(type = InsertBatchProvider.class, method = "dynamicSQL")
    int insertBatch(List<T> recordList);
    /**
     * 批量插入（所有字段） 与 insertBatch的不同
     *
     * @param recordList
     * @return
     */
    @org.apache.ibatis.annotations.UpdateProvider(type = InsertBatchProvider.class, method = "dynamicSQL")
    int updateBatch(List<T> recordList);
}
