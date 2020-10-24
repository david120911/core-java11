package alibaba.code.guideline.mysql.index.guide;

public class IndexGuideTest {


/**
 * (二) 索引规约
 * 1. 【强制】业务上具有唯一特性的字段，即使是多个字段的组合，也必须建成唯一索引。
 * 说明:不要以为唯一索引影响了 insert 速度，这个速度损耗可以忽略，但提高查找速度是明 显的;
 * 另外，即使在应用层做了非常完善的校验控制，只要没有唯一索引，根据墨菲定律，必 然有脏数据产生。
 * 2. 【强制】 超过三个表禁止 join。需要 join 的字段，数据类型必须绝对一致;多表关联查询 时，
 * 保证被关联的字段需要有索引。
 * 说明:即使双表 join 也要注意表索引、SQL 性能。
 * 3. 【强制】在 varchar 字段上建立索引时，必须指定索引长度，没必要对全字段建立索引，
 * 根据 实际文本区分度决定索引长度即可。 说明:索引的长度与区分度是一对矛盾体，一般对字符串类型数据，
 * 长度为 20 的索引，区分 度会高达 90%以上，可以使用 count(distinct left(列名, 索引长度))/count(*)的区分度 来确定。
 *
 *
 *
 *
 * 4. 【强制】页面搜索严禁左模糊或者全模糊，如果需要请走搜索引擎来解决。
 * 说明:索引文件具有 B-Tree 的最左前缀匹配特性，如果左边的值未确定，那么无法使用此索 引。
 * 5. 【推荐】如果有 order by 的场景，请注意利用索引的有序性。order by 最后的字段是组合
 * 索引的一部分，并且放在索引组合顺序的最后，避免出现 file_sort 的情况，影响查询性能。
 * 正例:where a=? and b=? order by c; 索引:a_b_c 反例:索引中有范围查找，那么索引有序性无法利用，
 * 如:WHERE a>10 ORDER BY b; 索引 a_b 无法排序。
 * 6. 【推荐】利用覆盖索引来进行查询操作，避免回表。
 * 说明:如果一本书需要知道第 11 章是什么标题，会翻开第 11 章对应的那一页吗?目录浏览 一下就好，
 * 这个目录就是起到覆盖索引的作用。 正例:能够建立索引的种类:主键索引、唯一索引、普通索引，
 * 而覆盖索引是一种查询的一种 效果，用explain的结果，extra列会出现:using index。
 * 7. 【推荐】利用延迟关联或者子查询优化超多分页场景。
 * 说明:MySQL 并不是跳过 offset 行，而是取 offset+N 行，然后返回放弃前 offset 行，
 * 返回 N 行，那当 offset 特别大的时候，效率就非常的低下，要么控制返回的总页数，
 * 要么对超过 特定阈值的页数进行 SQL 改写。
 * 正例:先快速定位需要获取的 id 段，然后再关联:
 * SELECT a.* FROM 表 1 a, (select id from 表 1 where 条件 LIMIT 100000,20 ) b where a.id=b.id
 * 8. 【推荐】SQL 性能优化的目标:至少要达到 range 级别，要求是 ref 级别，
 * 如果可以是 consts 最好。
 * 说明:
 * 1)consts 单表中最多只有一个匹配行(主键或者唯一索引)，在优化阶段即可读取到数据。
 * 2)ref 指的是使用普通的索引(normal index)。
 * 3)range 对索引进行范围检索。
 * 反例:explain 表的结果，type=index，索引物理文件全扫描，速度非常慢，
 * 这个 index 级 别比较 range 还低，与全表扫描是小巫见大巫。
 * 9. 【推荐】建组合索引的时候，区分度最高的在最左边。
 * 正例:如果 where a=? and b=? ，a 列的几乎接近于唯一值，那么只需要单建 idx_a 索引即 可。
 * 说明:存在非等号和等号混合判断条件时，在建索引时，请把等号条件的列前置。
 * 如:where a>? and b=? 那么即使 a 的区分度更高，也必须把 b 放在索引的最前列。
 * 10. 【推荐】防止因字段类型不同造成的隐式转换，导致索引失效。
 *
 *
 *11. 【参考】创建索引时避免有如下极端误解:
 * 1)宁滥勿缺。误认为一个查询就需要建一个索引。
 * 2)宁缺勿滥。误认为索引会消耗空间、严重拖慢更新和新增速度。
 * 3)抵制惟一索引。误认为业务的惟一性一律需要在应用层通过“先查后插”方式解决。
 *
 *
 *
 * **/









    public static void main(String[] args) {




    }

}
