package select
//primary key が返す値は0, 1件
import common.createSessionFactory
import database.UserMapper
import database.selectByPrimaryKey

fun main() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val user = mapper.selectByPrimaryKey(100)
        println(user)
        //主キーの値が
    }
}