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
}


