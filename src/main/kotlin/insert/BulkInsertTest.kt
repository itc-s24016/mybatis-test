package insert
//データを複数件追加する
import common.createSessionFactory
import database.User
import database.UserMapper
import database.insertMultiple

fun main() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)

        val addUserList = listOf(
            User(104, "Goro", 15, "Hello"),
            User(105, "Rokuro", 13, "Hello"),
        )
        val count = mapper.insertMultiple(addUserList)
        session.commit()
        println("${count}行のレコードを挿入しました")
    }
}