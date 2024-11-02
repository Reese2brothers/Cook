package com.hulikan.cook.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MainListDao {
    @Query("SELECT * FROM mainlist")
    fun getAll() : Flow<List<MainList>>
    @Query("SELECT wordkey FROM mainlist")
    suspend fun getAllKeys(): List<String>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mainList: MainList)
    @Update
    suspend fun update(mainList: MainList)
    @Delete
    suspend fun deleteList(mainList : MainList)
    @Query("DELETE FROM mainlist")
    suspend fun deleteAll()
    @Query("SELECT COUNT(*) FROM mainlist")
    suspend fun getRowCount(): Int
    @Query("SELECT * FROM mainlist WHERE wordkey = :wordkey")
    suspend fun getSectionByWordkey(wordkey: String): MainList?
    @Query("UPDATE or REPLACE mainlist SET text = :title, image = :image WHERE wordkey = :wordkey")
    suspend fun updateSection(title: String, image: Int, wordkey: String)
}

@Dao
interface FavouritesDao {
    @Query("SELECT * FROM favourites")
    fun getAll(): Flow<List<Favourites>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavourites(favourites: Favourites)

    @Delete
    suspend fun deleteFavourites(favourites: Favourites)

    @Query("DELETE FROM favourites")
    suspend fun deleteAll()

    @Query("SELECT EXISTS(SELECT * FROM Favourites WHERE title = :title AND favouriteskey = :key)")
    suspend fun isFavourite(title: String, key: String): Boolean

    @Query("DELETE FROM Favourites WHERE title = :title AND favouriteskey = :key")
    suspend fun deleteFavourite(title: String, key: String)

    @Query("SELECT COUNT(*) FROM favourites")
    suspend fun isEmpty(): Boolean

    @Query("SELECT COUNT(*) FROM favourites")
    suspend fun getCount(): Int
}

@Dao
interface OneDao {
    @Query("SELECT * FROM one")
    fun getAll(): Flow<List<One>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOne(one: One)

    @Delete
    suspend fun deleteOne(one: One)

    @Query("DELETE FROM one")
    suspend fun deleteAll()

    @Query("SELECT images FROM one WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE one SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM one")
    suspend fun getAllImages(): List<One>

    @Query("UPDATE one SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM One")
    suspend fun getTitle(): String

    @Query("SELECT content FROM One")
    suspend fun getContent(): String

    @Query("UPDATE one SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM one WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE one SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM one WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM one WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE one SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE one SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface TwoDao {
    @Query("SELECT * FROM two")
    fun getAll() : Flow<List<Two>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwo(two: Two)
    @Delete
    suspend fun deleteTwo(two: Two)
    @Query("DELETE FROM two")
    suspend fun deleteAll()
    @Query("SELECT images FROM two WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE two SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM two")
    suspend fun getAllImages(): List<Two>

    @Query("UPDATE two SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Two")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Two")
    suspend fun getContent(): String

    @Query("UPDATE two SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM two WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE two SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM two WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM two WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE two SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE two SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface ThreeDao {
    @Query("SELECT * FROM three")
    fun getAll() : Flow<List<Three>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThree(three: Three)
    @Delete
    suspend fun deleteThree(three: Three)
    @Query("DELETE FROM three")
    suspend fun deleteAll()
    @Query("SELECT images FROM three WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE three SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM three")
    suspend fun getAllImages(): List<Three>

    @Query("UPDATE three SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Three")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Three")
    suspend fun getContent(): String

    @Query("UPDATE three SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM three WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE three SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM three WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM three WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE three SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE three SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FourDao {
    @Query("SELECT * FROM four")
    fun getAll() : Flow<List<Four>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFour(four: Four)
    @Delete
    suspend fun deleteFour(four: Four)
    @Query("DELETE FROM four")
    suspend fun deleteAll()
    @Query("SELECT images FROM four WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE four SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM four")
    suspend fun getAllImages(): List<Four>

    @Query("UPDATE four SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Four")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Four")
    suspend fun getContent(): String

    @Query("UPDATE four SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM four WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE four SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM four WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM four WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE four SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE four SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FiveDao {
    @Query("SELECT * FROM five")
    fun getAll() : Flow<List<Five>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFive(five: Five)
    @Delete
    suspend fun deleteFive(five: Five)
    @Query("DELETE FROM five")
    suspend fun deleteAll()
    @Query("SELECT images FROM five WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE five SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM five")
    suspend fun getAllImages(): List<Five>

    @Query("UPDATE five SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Five")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Five")
    suspend fun getContent(): String

    @Query("UPDATE five SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM five WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE five SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM five WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM five WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE five SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE five SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface SixDao {
    @Query("SELECT * FROM six")
    fun getAll() : Flow<List<Six>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSix(six: Six)

    @Delete
    suspend fun deleteSix(six: Six)

    @Query("DELETE FROM six")
    suspend fun deleteAll()
    @Query("SELECT images FROM six WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE six SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM six")
    suspend fun getAllImages(): List<Six>

    @Query("UPDATE six SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Six")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Six")
    suspend fun getContent(): String

    @Query("UPDATE six SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM six WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE six SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM six WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM six WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE six SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE six SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface SevenDao {
    @Query("SELECT * FROM seven")
    fun getAll() : Flow<List<Seven>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeven(seven: Seven)

    @Delete
    suspend fun deleteSeven(seven: Seven)

    @Query("DELETE FROM seven")
    suspend fun deleteAll()
    @Query("SELECT images FROM seven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE seven SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM six")
    suspend fun getAllImages(): List<Seven>

    @Query("UPDATE six SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Seven")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Seven")
    suspend fun getContent(): String

    @Query("UPDATE six SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM six WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE six SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM six WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM six WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE six SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE six SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface EightDao {
    @Query("SELECT * FROM eight")
    fun getAll() : Flow<List<Eight>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEight(eight: Eight)

    @Delete
    suspend fun deleteEight(eight: Eight)

    @Query("DELETE FROM eight")
    suspend fun deleteAll()
    @Query("SELECT images FROM eight WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE eight SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM eight")
    suspend fun getAllImages(): List<Eight>

    @Query("UPDATE eight SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Eight")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Eight")
    suspend fun getContent(): String

    @Query("UPDATE eight SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM eight WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE eight SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM eight WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM eight WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE eight SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE eight SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface NineDao {
    @Query("SELECT * FROM nine")
    fun getAll() : Flow<List<Nine>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNine(nine: Nine)

    @Delete
    suspend fun deleteNine(nine: Nine)

    @Query("DELETE FROM nine")
    suspend fun deleteAll()
    @Query("SELECT images FROM nine WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE nine SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM nine")
    suspend fun getAllImages(): List<Nine>

    @Query("UPDATE nine SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Nine")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Nine")
    suspend fun getContent(): String

    @Query("UPDATE nine SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM nine WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE nine SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM nine WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM nine WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE nine SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE nine SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface TenDao {
    @Query("SELECT * FROM ten")
    fun getAll(): Flow<List<Ten>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTen(ten: Ten)

    @Delete
    suspend fun deleteTen(ten: Ten)

    @Query("DELETE FROM ten")
    suspend fun deleteAll()
    @Query("SELECT images FROM ten WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE ten SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM ten")
    suspend fun getAllImages(): List<Ten>

    @Query("UPDATE ten SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Ten")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Ten")
    suspend fun getContent(): String

    @Query("UPDATE ten SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM ten WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE ten SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM ten WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM ten WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE ten SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE ten SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface ElevenDao {
    @Query("SELECT * FROM eleven")
    fun getAll(): Flow<List<Eleven>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEleven(eleven: Eleven)

    @Delete
    suspend fun deleteEleven(eleven: Eleven)

    @Query("DELETE FROM eleven")
    suspend fun deleteAll()
    @Query("SELECT images FROM eleven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE eleven SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM eleven")
    suspend fun getAllImages(): List<Eleven>

    @Query("UPDATE eleven SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Eleven")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Eleven")
    suspend fun getContent(): String

    @Query("UPDATE eleven SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM eleven WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE eleven SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM eleven WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM eleven WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE eleven SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE eleven SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface TwelveDao {
    @Query("SELECT * FROM twelve")
    fun getAll(): Flow<List<Twelve>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwelve(twelve: Twelve)

    @Delete
    suspend fun deleteTwelve(twelve: Twelve)

    @Query("DELETE FROM twelve")
    suspend fun deleteAll()
    @Query("SELECT images FROM twelve WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE twelve SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM twelve")
    suspend fun getAllImages(): List<Twelve>

    @Query("UPDATE twelve SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Twelve")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Twelve")
    suspend fun getContent(): String

    @Query("UPDATE twelve SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM twelve WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE twelve SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM twelve WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM twelve WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE twelve SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE twelve SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface ThirteenDao {
    @Query("SELECT * FROM thirteen")
    fun getAll(): Flow<List<Thirteen>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirteen(thirteen: Thirteen)

    @Delete
    suspend fun deleteThirteen(thirteen: Thirteen)

    @Query("DELETE FROM thirteen")
    suspend fun deleteAll()
    @Query("SELECT images FROM thirteen WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE thirteen SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM thirteen")
    suspend fun getAllImages(): List<Thirteen>

    @Query("UPDATE thirteen SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Thirteen")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Thirteen")
    suspend fun getContent(): String

    @Query("UPDATE thirteen SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM thirteen WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE thirteen SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirteen WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM thirteen WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE thirteen SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE thirteen SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FourteenDao {
    @Query("SELECT * FROM fourteen")
    fun getAll(): Flow<List<Fourteen>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFourteen(fourteen: Fourteen)

    @Delete
    suspend fun deleteFourteen(fourteen: Fourteen)

    @Query("DELETE FROM fourteen")
    suspend fun deleteAll()
    @Query("SELECT images FROM fourteen WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE fourteen SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM fourteen")
    suspend fun getAllImages(): List<Fourteen>

    @Query("UPDATE fourteen SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Fourteen")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Fourteen")
    suspend fun getContent(): String

    @Query("UPDATE fourteen SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM fourteen WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE fourteen SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM fourteen WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM fourteen WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE fourteen SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE fourteen SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FifteenDao {
    @Query("SELECT * FROM fifteen")
    fun getAll(): Flow<List<Fifteen>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFifteen(fifteen: Fifteen)

    @Delete
    suspend fun deleteFifteen(fifteen: Fifteen)

    @Query("DELETE FROM fifteen")
    suspend fun deleteAll()
    @Query("SELECT images FROM fifteen WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE fifteen SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM fifteen")
    suspend fun getAllImages(): List<Fifteen>

    @Query("UPDATE fifteen SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Fifteen")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Fifteen")
    suspend fun getContent(): String

    @Query("UPDATE fifteen SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM fifteen WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE fifteen SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM fifteen WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM fifteen WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE fifteen SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE fifteen SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface SixteenDao {
    @Query("SELECT * FROM sixteen")
    fun getAll(): Flow<List<Sixteen>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSixteen(sixteen: Sixteen)

    @Delete
    suspend fun deleteSixteen(sixteen: Sixteen)

    @Query("DELETE FROM sixteen")
    suspend fun deleteAll()
    @Query("SELECT images FROM sixteen WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE sixteen SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM sixteen")
    suspend fun getAllImages(): List<Sixteen>

    @Query("UPDATE sixteen SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Sixteen")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Sixteen")
    suspend fun getContent(): String

    @Query("UPDATE sixteen SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM sixteen WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE sixteen SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM sixteen WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM sixteen WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE sixteen SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE sixteen SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface SeventeenDao {
    @Query("SELECT * FROM seventeen")
    fun getAll(): Flow<List<Seventeen>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeventeen(seventeen: Seventeen)

    @Delete
    suspend fun deleteSeventeen(seventeen: Seventeen)

    @Query("DELETE FROM seventeen")
    suspend fun deleteAll()
    @Query("SELECT images FROM seventeen WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE seventeen SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM seventeen")
    suspend fun getAllImages(): List<Seventeen>

    @Query("UPDATE seventeen SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Seventeen")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Seventeen")
    suspend fun getContent(): String

    @Query("UPDATE seventeen SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM seventeen WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE seventeen SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM seventeen WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM seventeen WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE seventeen SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE seventeen SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface EighteenDao {
    @Query("SELECT * FROM eighteen")
    fun getAll(): Flow<List<Eighteen>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEighteen(eighteen: Eighteen)

    @Delete
    suspend fun deleteEighteen(eighteen: Eighteen)

    @Query("DELETE FROM eighteen")
    suspend fun deleteAll()
    @Query("SELECT images FROM eighteen WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE eighteen SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM eighteen")
    suspend fun getAllImages(): List<Eighteen>

    @Query("UPDATE eighteen SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Eighteen")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Eighteen")
    suspend fun getContent(): String

    @Query("UPDATE eighteen SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM eighteen WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE eighteen SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM eighteen WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM eighteen WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE eighteen SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE eighteen SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface NineteenDao {
    @Query("SELECT * FROM nineteen")
    fun getAll(): Flow<List<Nineteen>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNineteen(nineteen: Nineteen)

    @Delete
    suspend fun deleteNineteen(nineteen: Nineteen)

    @Query("DELETE FROM nineteen")
    suspend fun deleteAll()
    @Query("SELECT images FROM nineteen WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE nineteen SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM nineteen")
    suspend fun getAllImages(): List<Nineteen>

    @Query("UPDATE nineteen SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Nineteen")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Nineteen")
    suspend fun getContent(): String

    @Query("UPDATE nineteen SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM nineteen WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE nineteen SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM nineteen WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM nineteen WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE nineteen SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE nineteen SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}
@Dao
interface TwentyDao {
    @Query("SELECT * FROM twenty")
    fun getAll(): Flow<List<Twenty>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwenty(twenty: Twenty)

    @Delete
    suspend fun deleteTwenty(twenty: Twenty)

    @Query("DELETE FROM twenty")
    suspend fun deleteAll()
    @Query("SELECT images FROM twenty WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE twenty SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM twenty")
    suspend fun getAllImages(): List<Twenty>

    @Query("UPDATE twenty SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Twenty")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Twenty")
    suspend fun getContent(): String

    @Query("UPDATE twenty SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM twenty WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE twenty SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM twenty WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM twenty WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE twenty SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE twenty SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface TwentyOneDao {
    @Query("SELECT * FROM twentyOne")
    fun getAll(): Flow<List<TwentyOne>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyOne(twentyOne: TwentyOne)

    @Delete
    suspend fun deleteTwentyOne(twentyOne: TwentyOne)

    @Query("DELETE FROM twentyOne")
    suspend fun deleteAll()
    @Query("SELECT images FROM twentyone WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE twentyone SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM twentyone")
    suspend fun getAllImages(): List<TwentyOne>

    @Query("UPDATE twentyone SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM TwentyOne")
    suspend fun getTitle(): String

    @Query("SELECT content FROM TwentyOne")
    suspend fun getContent(): String

    @Query("UPDATE twentyone SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM twentyone WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE twentyone SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentyone WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM twentyone WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE twentyone SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE twentyone SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface TwentyTwoDao {
    @Query("SELECT * FROM twentyTwo")
    fun getAll(): Flow<List<TwentyTwo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyTwo(twentyTwo: TwentyTwo)

    @Delete
    suspend fun deleteTwentyTwo(twentyTwo: TwentyTwo)

    @Query("DELETE FROM twentyTwo")
    suspend fun deleteAll()
    @Query("SELECT images FROM twentytwo WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE twentytwo SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM twentytwo")
    suspend fun getAllImages(): List<TwentyTwo>

    @Query("UPDATE twentytwo SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM TwentyTwo")
    suspend fun getTitle(): String

    @Query("SELECT content FROM TwentyTwo")
    suspend fun getContent(): String

    @Query("UPDATE twentytwo SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM twentytwo WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE twentytwo SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentytwo WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM twentytwo WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE twentytwo SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE twentytwo SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface TwentyThreeDao {
    @Query("SELECT * FROM twentyThree")
    fun getAll(): Flow<List<TwentyThree>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyThree(twentyThree: TwentyThree)

    @Delete
    suspend fun deleteTwentyThree(twentyThree: TwentyThree)

    @Query("DELETE FROM twentyThree")
    suspend fun deleteAll()
    @Query("SELECT images FROM twentythree WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE twentythree SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM twentythree")
    suspend fun getAllImages(): List<TwentyThree>

    @Query("UPDATE twentythree SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM TwentyThree")
    suspend fun getTitle(): String

    @Query("SELECT content FROM TwentyThree")
    suspend fun getContent(): String

    @Query("UPDATE twentythree SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM twentythree WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE twentythree SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentythree WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM twentythree WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE twentythree SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE twentythree SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface TwentyFourDao {
    @Query("SELECT * FROM twentyFour")
    fun getAll(): Flow<List<TwentyFour>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyFour(twentyFour: TwentyFour)

    @Delete
    suspend fun deleteTwentyFour(twentyFour: TwentyFour)

    @Query("DELETE FROM twentyFour")
    suspend fun deleteAll()
    @Query("SELECT images FROM twentyfour WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE twentyfour SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM twentyfour")
    suspend fun getAllImages(): List<TwentyFour>

    @Query("UPDATE twentyfour SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM TwentyFour")
    suspend fun getTitle(): String

    @Query("SELECT content FROM TwentyFour")
    suspend fun getContent(): String

    @Query("UPDATE twentyfour SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM twentyfour WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE twentyfour SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentyfour WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM twentyfour WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE twentyfour SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE twentyfour SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface TwentyFiveDao {
    @Query("SELECT * FROM twentyFive")
    fun getAll(): Flow<List<TwentyFive>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyFive(twentyFive: TwentyFive)

    @Delete
    suspend fun deleteTwentyFive(twentyFive: TwentyFive)

    @Query("DELETE FROM twentyFive")
    suspend fun deleteAll()
    @Query("SELECT images FROM twentyfive WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE twentyfive SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM twentyfive")
    suspend fun getAllImages(): List<TwentyFive>

    @Query("UPDATE twentyfive SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM TwentyFive")
    suspend fun getTitle(): String

    @Query("SELECT content FROM TwentyFive")
    suspend fun getContent(): String

    @Query("UPDATE twentyfive SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM twentyfive WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE twentyfive SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentyfive WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM twentyfive WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE twentyfive SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE twentyfive SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface TwentySixDao {
    @Query("SELECT * FROM twentySix")
    fun getAll(): Flow<List<TwentySix>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentySix(twentySix: TwentySix)

    @Delete
    suspend fun deleteTwentySix(twentySix: TwentySix)

    @Query("DELETE FROM twentySix")
    suspend fun deleteAll()
    @Query("SELECT images FROM twentysix WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE twentysix SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM twentysix")
    suspend fun getAllImages(): List<TwentySix>

    @Query("UPDATE twentysix SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM TwentySix")
    suspend fun getTitle(): String

    @Query("SELECT content FROM TwentySix")
    suspend fun getContent(): String

    @Query("UPDATE twentysix SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM twentysix WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE twentysix SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentysix WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM twentysix WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE twentysix SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE twentysix SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface TwentySevenDao {
    @Query("SELECT * FROM twentySeven")
    fun getAll(): Flow<List<TwentySeven>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentySeven(twentySeven: TwentySeven)

    @Delete
    suspend fun deleteTwentySeven(twentySeven: TwentySeven)

    @Query("DELETE FROM twentySeven")
    suspend fun deleteAll()
    @Query("SELECT images FROM twentyseven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE twentyseven SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM twentyseven")
    suspend fun getAllImages(): List<TwentySeven>

    @Query("UPDATE twentyseven SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM TwentySeven")
    suspend fun getTitle(): String

    @Query("SELECT content FROM TwentySeven")
    suspend fun getContent(): String

    @Query("UPDATE twentyseven SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM twentyseven WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE twentyseven SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentyseven WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM twentyseven WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE twentyseven SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE twentyseven SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface TwentyEightDao {
    @Query("SELECT * FROM twentyEight")
    fun getAll(): Flow<List<TwentyEight>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyEight(twentyEight: TwentyEight)

    @Delete
    suspend fun deleteTwentyEight(twentyEight: TwentyEight)

    @Query("DELETE FROM twentyEight")
    suspend fun deleteAll()
    @Query("SELECT images FROM twentyeight WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE twentyeight SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM twentyeight")
    suspend fun getAllImages(): List<TwentyEight>

    @Query("UPDATE twentyeight SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM TwentyEight")
    suspend fun getTitle(): String

    @Query("SELECT content FROM TwentyEight")
    suspend fun getContent(): String

    @Query("UPDATE twentyeight SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM twentyeight WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE twentyeight SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentyeight WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM twentyeight WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE twentyeight SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE twentyeight SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface TwentyNineDao {
    @Query("SELECT * FROM twentyNine")
    fun getAll(): Flow<List<TwentyNine>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyNine(twentyNine: TwentyNine)

    @Delete
    suspend fun deleteTwentyNine(twentyNine: TwentyNine)

    @Query("DELETE FROM twentyNine")
    suspend fun deleteAll()
    @Query("SELECT images FROM twentynine WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE twentynine SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM twentynine")
    suspend fun getAllImages(): List<TwentyNine>

    @Query("UPDATE twentynine SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM TwentyNine")
    suspend fun getTitle(): String

    @Query("SELECT content FROM TwentyNine")
    suspend fun getContent(): String

    @Query("UPDATE twentynine SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM twentynine WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE twentynine SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentynine WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM twentynine WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE twentynine SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE twentynine SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface ThirtyDao {
    @Query("SELECT * FROM thirty")
    fun getAll(): Flow<List<Thirty>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirty(thirty: Thirty)

    @Delete
    suspend fun deleteThirty(thirty: Thirty)

    @Query("DELETE FROM thirty")
    suspend fun deleteAll()
    @Query("SELECT images FROM thirty WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String
    @Query("UPDATE thirty SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM thirty")
    suspend fun getAllImages(): List<Thirty>

    @Query("UPDATE thirty SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM Thirty")
    suspend fun getTitle(): String

    @Query("SELECT content FROM Thirty")
    suspend fun getContent(): String

    @Query("UPDATE thirty SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM thirty WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE thirty SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirty WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM thirty WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE thirty SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE thirty SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface ThirtyOneDao {
    @Query("SELECT * FROM thirtyone")
    fun getAll(): Flow<List<ThirtyOne>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirtyOne(thirtyOne: ThirtyOne)

    @Delete
    suspend fun deleteThirtyOne(thirtyOne: ThirtyOne)

    @Query("DELETE FROM thirtyone")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtyone WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE thirtyone SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM thirtyone")
    suspend fun getAllImages(): List<ThirtyOne>

    @Query("UPDATE thirtyone SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM thirtyone")
    suspend fun getTitle(): String

    @Query("SELECT content FROM thirtyone")
    suspend fun getContent(): String

    @Query("UPDATE thirtyone SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM thirtyone WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE thirtyone SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtyone WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM thirtyone WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE thirtyone SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE thirtyone SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface ThirtyTwoDao {
    @Query("SELECT * FROM thirtytwo")
    fun getAll(): Flow<List<ThirtyTwo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirtyTwo(thirtyTwo: ThirtyTwo)

    @Delete
    suspend fun deleteThirtyTwo(thirtyTwo: ThirtyTwo)

    @Query("DELETE FROM thirtytwo")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtytwo WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE thirtytwo SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM thirtytwo")
    suspend fun getAllImages(): List<ThirtyTwo>

    @Query("UPDATE thirtytwo SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(
        newTitle: String,
        newContent: String,
        oldTitle: String,
        currentImage: String
    )

    @Query("SELECT title FROM thirtytwo")
    suspend fun getTitle(): String

    @Query("SELECT content FROM thirtytwo")
    suspend fun getContent(): String

    @Query("UPDATE thirtytwo SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM thirtytwo WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE thirtytwo SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtytwo WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM thirtytwo WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE thirtytwo SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE thirtytwo SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface ThirtyThreeDao {
    @Query("SELECT * FROM thirtythree")
    fun getAll(): Flow<List<ThirtyThree>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirtyThree(thirtyThree: ThirtyThree)

    @Delete
    suspend fun deleteThirtyThree(thirtyThree: ThirtyThree)

    @Query("DELETE FROM thirtythree")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtythree WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE thirtythree SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM thirtythree")
    suspend fun getAllImages(): List<ThirtyThree>

    @Query("UPDATE thirtythree SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM thirtythree")
    suspend fun getTitle(): String

    @Query("SELECT content FROM thirtythree")
    suspend fun getContent(): String

    @Query("UPDATE thirtythree SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM thirtythree WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE thirtythree SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtythree WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM thirtythree WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE thirtythree SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE thirtythree SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface ThirtyFourDao {
    @Query("SELECT * FROM thirtyFour")
    fun getAll(): Flow<List<ThirtyFour>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirtyFour(thirtyFour: ThirtyFour)

    @Delete
    suspend fun deleteThirtyFour(thirtyFour: ThirtyFour)

    @Query("DELETE FROM thirtyFour")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtyFour WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE thirtyFour SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM thirtyFour")
    suspend fun getAllImages(): List<ThirtyFour>

    @Query("UPDATE thirtyFour SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM thirtyFour")
    suspend fun getTitle(): String

    @Query("SELECT content FROM thirtyFour")
    suspend fun getContent(): String

    @Query("UPDATE thirtyFour SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM thirtyFour WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE thirtyFour SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtyFour WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM thirtyFour WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE thirtyFour SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE thirtyFour SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface ThirtyFiveDao {
    @Query("SELECT * FROM thirtyFive")
    fun getAll(): Flow<List<ThirtyFive>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirtyFive(thirtyFive: ThirtyFive)

    @Delete
    suspend fun deleteThirtyFive(thirtyFive: ThirtyFive)

    @Query("DELETE FROM thirtyFive")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtyFive WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE thirtyFive SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM thirtyFive")
    suspend fun getAllImages(): List<ThirtyFive>

    @Query("UPDATE thirtyFive SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM thirtyFive")
    suspend fun getTitle(): String

    @Query("SELECT content FROM thirtyFive")
    suspend fun getContent(): String

    @Query("UPDATE thirtyFive SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM thirtyFive WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE thirtyFive SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtyFive WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM thirtyFive WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE thirtyFive SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE thirtyFive SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface ThirtySixDao {
    @Query("SELECT * FROM thirtySix")
    fun getAll(): Flow<List<ThirtySix>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirtySix(thirtySix: ThirtySix)

    @Delete
    suspend fun deleteThirtySix(thirtySix: ThirtySix)

    @Query("DELETE FROM thirtySix")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtySix WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE thirtySix SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM thirtySix")
    suspend fun getAllImages(): List<ThirtySix>

    @Query("UPDATE thirtySix SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM thirtySix")
    suspend fun getTitle(): String

    @Query("SELECT content FROM thirtySix")
    suspend fun getContent(): String

    @Query("UPDATE thirtySix SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM thirtySix WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE thirtySix SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtySix WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM thirtySix WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE thirtySix SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE thirtySix SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface ThirtySevenDao {
    @Query("SELECT * FROM thirtySeven")
    fun getAll(): Flow<List<ThirtySeven>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirtySeven(thirtySeven: ThirtySeven)

    @Delete
    suspend fun deleteThirtySeven(thirtySeven: ThirtySeven)

    @Query("DELETE FROM thirtySeven")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtySeven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE thirtySeven SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM thirtySeven")
    suspend fun getAllImages(): List<ThirtySeven>

    @Query("UPDATE thirtySeven SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM thirtySeven")
    suspend fun getTitle(): String

    @Query("SELECT content FROM thirtySeven")
    suspend fun getContent(): String

    @Query("UPDATE thirtySeven SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM thirtySeven WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE thirtySeven SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtySeven WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM thirtySeven WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE thirtySeven SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE thirtySeven SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface ThirtyEightDao {
    @Query("SELECT * FROM thirtyEight")
    fun getAll(): Flow<List<ThirtyEight>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirtyEight(thirtyEight: ThirtyEight)

    @Delete
    suspend fun deleteThirtyEight(thirtyEight: ThirtyEight)

    @Query("DELETE FROM thirtyEight")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtyEight WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE thirtyEight SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM thirtyEight")
    suspend fun getAllImages(): List<ThirtyEight>

    @Query("UPDATE thirtyEight SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM thirtyEight")
    suspend fun getTitle(): String

    @Query("SELECT content FROM thirtyEight")
    suspend fun getContent(): String

    @Query("UPDATE thirtyEight SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM thirtyEight WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE thirtyEight SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtyEight WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM thirtyEight WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE thirtyEight SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE thirtyEight SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface ThirtyNineDao {
    @Query("SELECT * FROM thirtyNine")
    fun getAll(): Flow<List<ThirtyNine>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirtyNine(thirtyNine: ThirtyNine)

    @Delete
    suspend fun deleteThirtyNine(thirtyNine: ThirtyNine)

    @Query("DELETE FROM thirtyNine")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtyNine WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE thirtyNine SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM thirtyNine")
    suspend fun getAllImages(): List<ThirtyNine>

    @Query("UPDATE thirtyNine SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM thirtyNine")
    suspend fun getTitle(): String

    @Query("SELECT content FROM thirtyNine")
    suspend fun getContent(): String

    @Query("UPDATE thirtyNine SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM thirtyNine WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE thirtyNine SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtyNine WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM thirtyNine WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE thirtyNine SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE thirtyNine SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FortyDao {
    @Query("SELECT * FROM forty")
    fun getAll(): Flow<List<Forty>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForty(forty: Forty)

    @Delete
    suspend fun deleteForty(forty: Forty)

    @Query("DELETE FROM forty")
    suspend fun deleteAll()

    @Query("SELECT images FROM forty WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE forty SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM forty")
    suspend fun getAllImages(): List<Forty>

    @Query("UPDATE forty SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM forty")
    suspend fun getTitle(): String

    @Query("SELECT content FROM forty")
    suspend fun getContent(): String

    @Query("UPDATE forty SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM forty WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE forty SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM forty WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM forty WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE forty SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE forty SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FortyOneDao {
    @Query("SELECT * FROM fortyOne")
    fun getAll(): Flow<List<FortyOne>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFortyOne(fortyOne: FortyOne)

    @Delete
    suspend fun deleteFortyOne(fortyOne: FortyOne)

    @Query("DELETE FROM fortyOne")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortyOne WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE fortyOne SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM fortyOne")
    suspend fun getAllImages(): List<FortyOne>

    @Query("UPDATE fortyOne SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM fortyOne")
    suspend fun getTitle(): String

    @Query("SELECT content FROM fortyOne")
    suspend fun getContent(): String

    @Query("UPDATE fortyOne SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM fortyOne WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE fortyOne SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortyOne WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM fortyOne WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE fortyOne SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE fortyOne SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FortyTwoDao {
    @Query("SELECT * FROM fortyTwo")
    fun getAll(): Flow<List<FortyTwo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFortyTwo(fortyTwo: FortyTwo)

    @Delete
    suspend fun deleteFortyTwo(fortyTwo: FortyTwo)

    @Query("DELETE FROM fortyTwo")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortyTwo WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE fortyTwo SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM fortyTwo")
    suspend fun getAllImages(): List<FortyTwo>

    @Query("UPDATE fortyTwo SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM fortyTwo")
    suspend fun getTitle(): String

    @Query("SELECT content FROM fortyTwo")
    suspend fun getContent(): String

    @Query("UPDATE fortyTwo SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM fortyTwo WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE fortyTwo SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortyTwo WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM fortyTwo WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE fortyTwo SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE fortyTwo SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FortyThreeDao {
    @Query("SELECT * FROM fortyThree")
    fun getAll(): Flow<List<FortyThree>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFortyThree(fortyThree: FortyThree)

    @Delete
    suspend fun deleteFortyThree(fortyThree: FortyThree)

    @Query("DELETE FROM fortyThree")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortyThree WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE fortyThree SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM fortyThree")
    suspend fun getAllImages(): List<FortyThree>

    @Query("UPDATE fortyThree SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM fortyThree")
    suspend fun getTitle(): String

    @Query("SELECT content FROM fortyThree")
    suspend fun getContent(): String

    @Query("UPDATE fortyThree SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM fortyThree WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE fortyThree SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortyThree WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM fortyThree WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE fortyThree SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE fortyThree SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FortyFourDao {
    @Query("SELECT * FROM fortyFour")
    fun getAll(): Flow<List<FortyFour>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFortyFour(fortyFour: FortyFour)

    @Delete
    suspend fun deleteFortyFour(fortyFour: FortyFour)

    @Query("DELETE FROM fortyFour")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortyFour WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE fortyFour SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM fortyFour")
    suspend fun getAllImages(): List<FortyFour>

    @Query("UPDATE fortyFour SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM fortyFour")
    suspend fun getTitle(): String

    @Query("SELECT content FROM fortyFour")
    suspend fun getContent(): String

    @Query("UPDATE fortyFour SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM fortyFour WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE fortyFour SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortyFour WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM fortyFour WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE fortyFour SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE fortyFour SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FortyFiveDao {
    @Query("SELECT * FROM fortyFive")
    fun getAll(): Flow<List<FortyFive>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFortyFive(fortyFive: FortyFive)

    @Delete
    suspend fun deleteFortyFive(fortyFive: FortyFive)

    @Query("DELETE FROM fortyFive")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortyFive WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE fortyFive SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM fortyFive")
    suspend fun getAllImages(): List<FortyFive>

    @Query("UPDATE fortyFive SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM fortyFive")
    suspend fun getTitle(): String

    @Query("SELECT content FROM fortyFive")
    suspend fun getContent(): String

    @Query("UPDATE fortyFive SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM fortyFive WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE fortyFive SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortyFive WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM fortyFive WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE fortyFive SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE fortyFive SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FortySixDao {
    @Query("SELECT * FROM fortySix")
    fun getAll(): Flow<List<FortySix>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFortySix(fortySix: FortySix)

    @Delete
    suspend fun deleteFortySix(fortySix: FortySix)

    @Query("DELETE FROM fortySix")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortySix WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE fortySix SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM fortySix")
    suspend fun getAllImages(): List<FortySix>

    @Query("UPDATE fortySix SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM fortySix")
    suspend fun getTitle(): String

    @Query("SELECT content FROM fortySix")
    suspend fun getContent(): String

    @Query("UPDATE fortySix SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM fortySix WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE fortySix SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortySix WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM fortySix WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE fortySix SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE fortySix SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FortySevenDao {
    @Query("SELECT * FROM fortySeven")
    fun getAll(): Flow<List<FortySeven>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFortySeven(fortySeven: FortySeven)

    @Delete
    suspend fun deleteFortySeven(fortySeven: FortySeven)

    @Query("DELETE FROM fortySeven")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortySeven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE fortySeven SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM fortySeven")
    suspend fun getAllImages(): List<FortySeven>

    @Query("UPDATE fortySeven SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM fortySeven")
    suspend fun getTitle(): String

    @Query("SELECT content FROM fortySeven")
    suspend fun getContent(): String

    @Query("UPDATE fortySeven SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM fortySeven WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE fortySeven SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortySeven WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM fortySeven WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE fortySeven SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE fortySeven SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FortyEightDao {
    @Query("SELECT * FROM fortyEight")
    fun getAll(): Flow<List<FortyEight>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFortyEight(fortyEight: FortyEight)

    @Delete
    suspend fun deleteFortyEight(fortyEight: FortyEight)

    @Query("DELETE FROM fortyEight")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortyEight WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE fortyEight SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM fortyEight")
    suspend fun getAllImages(): List<FortyEight>

    @Query("UPDATE fortyEight SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM fortyEight")
    suspend fun getTitle(): String

    @Query("SELECT content FROM fortyEight")
    suspend fun getContent(): String

    @Query("UPDATE fortyEight SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM fortyEight WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE fortyEight SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortyEight WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM fortyEight WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE fortyEight SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE fortyEight SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FortyNineDao {
    @Query("SELECT * FROM fortyNine")
    fun getAll(): Flow<List<FortyNine>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFortyNine(fortyNine: FortyNine)

    @Delete
    suspend fun deleteFortyNine(fortyNine: FortyNine)

    @Query("DELETE FROM fortyNine")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortyNine WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE fortyNine SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM fortyNine")
    suspend fun getAllImages(): List<FortyNine>

    @Query("UPDATE fortyNine SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM fortyNine")
    suspend fun getTitle(): String

    @Query("SELECT content FROM fortyNine")
    suspend fun getContent(): String

    @Query("UPDATE fortyNine SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM fortyNine WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE fortyNine SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortyNine WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM fortyNine WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE fortyNine SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE fortyNine SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}

@Dao
interface FiftyDao {
    @Query("SELECT * FROM fifty")
    fun getAll(): Flow<List<Fifty>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFifty(fifty: Fifty)

    @Delete
    suspend fun deleteFifty(fifty: Fifty)

    @Query("DELETE FROM fifty")
    suspend fun deleteAll()

    @Query("SELECT images FROM fifty WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE fifty SET images = :images WHERE title = :title")
    suspend fun updateImages(title: String, images: String)

    @Query("SELECT * FROM fifty")
    suspend fun getAllImages(): List<Fifty>

    @Query("UPDATE fifty SET title = :newTitle, content = :newContent, images = :currentImage WHERE title = :oldTitle")
    suspend fun updateRecepie(newTitle: String, newContent: String, oldTitle: String, currentImage: String)

    @Query("SELECT title FROM fifty")
    suspend fun getTitle(): String

    @Query("SELECT content FROM fifty")
    suspend fun getContent(): String

    @Query("UPDATE fifty SET videos = :videos WHERE title = :title")
    suspend fun updateVideos(title: String, videos: String)

    @Query("SELECT videos FROM fifty WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE fifty SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE title = :title")
    suspend fun appendVideo(title: String, newVideo: String)

    @Query("SELECT COUNT(*) FROM fifty WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int

    @Query("SELECT images FROM fifty WHERE title = :title")
    suspend fun getImages(title: String): String?

    @Query("UPDATE fifty SET images = CASE WHEN images IS NULL OR images = '' THEN :images ELSE images || ',' || :images END WHERE title = :title")
    suspend fun appendImage(title: String, images: String)

    @Query("UPDATE fifty SET images = '' WHERE title = :title")
    suspend fun clearImages(title: String)
}




