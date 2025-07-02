package update
//主キー以外の値を指定してデータを更新する
import common.createSessionFactory
import database.UserDynamicSqlSupport.age
import database.UserDynamicSqlSupport.profile
import database.UserMapper
import database.update

fun main() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)

        val count = mapper.update{
            set(profile) equalTo "Hey"
            where {
                age isBetween 15 and 18
                }
        }
        session.commit()
        println("${count}行のレコードを更新しました")

    }
}