package update
//主キーを指定してデータを更新する
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
        /*
        【updateByPrimaryKeySelectiveの場合】
        update user set profile="Bye" where id = 105;
        指定した列のデータが更新される

        【updateByPrimaryKeyの場合】
        update user set id = null, name = null, age = null, profile="Bye" where id = 105;
        全ての列のデータが更新される
        */
        session.commit()
        println("${count}行のレコードを更新しました")
    }
}