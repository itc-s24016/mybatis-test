package select
//count で検索
import common.createSessionFactory
import database.UserDynamicSqlSupport.age
import database.UserMapper
import database.count

fun main() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.count {
            where {
                age isGreaterThanOrEqualTo 25
            }
        }
        //年齢が 25歳以上 のデータの件数を返す
        println("SELECT COUNT(*) FROM user WHERE age >= 25;")
        println("count: ${count}")

        val allCount = mapper.count {}
        /* .count{ allRows() }でもいい
        allRows() : 中身の記述忘れではなく、「全件取得」をするという意図を表すなんの効果もない関数
        */
        println("SELECT COUNT(*) FROM user;")
        println("count: ${allCount}")
    }
}