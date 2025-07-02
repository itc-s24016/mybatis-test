package update
//データを更新する
import common.createSessionFactory
import database.User
import database.UserMapper
import database.updateByPrimaryKeySelective

fun main() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val user = User(105, profile = "Bye")//更新データ( プロフィールの内容 )

        //主キーを指定して更新する関数
        val count = mapper.updateByPrimaryKeySelective(user)
        session.commit()
        println("${count}行のレコードを更新しました")
    }
}