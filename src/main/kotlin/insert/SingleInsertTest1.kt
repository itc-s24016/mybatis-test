package insert
//データを一件追加する
import common.createSessionFactory
import database.User
import database.UserMapper
import database.insert

fun main() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val user = User(103, "Shiro", 18, "Hello")//追加用のデータ
        val count = mapper.insert(user)
        session.commit()
        println("${count}行のレコードを挿入しました")

        //1回目：1行のレコードを挿入しました
        //2回目：Error: 1062-23000: Duplicate entry '103' for key 'PRIMARY'
        // 理由：主キーは重複しないルールなので、同じデータを追加しようとするとエラーになる
        //※Duplicate = 重複
    }
}