package select
//主キーで検索
import common.createSessionFactory
import database.UserMapper
import database.selectByPrimaryKey

fun main() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)

        //primary key が返す値は0, 1件
        val user = mapper.selectByPrimaryKey(100)
        println(user)
    }
}