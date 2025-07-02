package select
//それ以外が返す値は１件以上
import common.createSessionFactory
import database.UserDynamicSqlSupport.age
import database.UserDynamicSqlSupport.name
import database.UserMapper
import database.select

fun main() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val list1 = mapper.select {
            where {
                /* (ctrl + Space) + (alt + Enter)で
                database.UserDynamicSqlSupport.age をインポートして短縮 */
                name isEqualTo "Jiro"
            }
        }
        //名前が Jiro のデータを返す
        println("SELECT * FROM user WHERE name = \"Jiro\"")
        println(list1)

        val list2 = mapper.select {
            where {
                age isGreaterThanOrEqualTo 25
            }
        }
        //年齢が 25歳以上 のデータを返す
        println("SELECT * FROM user WHERE age >= 25;")
        println(list2)
    }
}