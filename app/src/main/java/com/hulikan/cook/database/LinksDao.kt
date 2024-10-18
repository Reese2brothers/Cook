package com.hulikan.cook.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface OneLinksDao {
    @Query("SELECT * FROM oneLinks")
    fun getAll() : Flow<List<OneLinks>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneLinks(oneLinks: OneLinks)
    @Delete
    suspend fun deleteOneLinks(oneLinks: OneLinks)
    @Query("DELETE FROM oneLinks")
    suspend fun deleteAll()
}
@Dao
interface TwoLinksDao {
    @Query("SELECT * FROM twoLinks")
    fun getAll() : Flow<List<TwoLinks>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwoLinks(twoLinks: TwoLinks)
    @Delete
    suspend fun deleteTwoLinks(twoLinks: TwoLinks)
    @Query("DELETE FROM twoLinks")
    suspend fun deleteAll()
}
@Dao
interface ThreeLinksDao {
    @Query("SELECT * FROM threeLinks")
    fun getAll() : Flow<List<ThreeLinks>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThreeLinks(threeLinks: ThreeLinks)
    @Delete
    suspend fun deleteThreeLinks(threeLinks: ThreeLinks)
    @Query("DELETE FROM threeLinks")
    suspend fun deleteAll()
}
@Dao
interface FourLinksDao {
    @Query("SELECT * FROM fourLinks")
    fun getAll() : Flow<List<FourLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFourLinks(fourLinks: FourLinks)

    @Delete
    suspend fun deleteFourLinks(fourLinks: FourLinks)

    @Query("DELETE FROM fourLinks")
    suspend fun deleteAll()
}

@Dao
interface FiveLinksDao {
    @Query("SELECT * FROM fiveLinks")
    fun getAll() : Flow<List<FiveLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFiveLinks(fiveLinks: FiveLinks)

    @Delete
    suspend fun deleteFiveLinks(fiveLinks: FiveLinks)

    @Query("DELETE FROM fiveLinks")
    suspend fun deleteAll()
}

@Dao
interface SixLinksDao {
    @Query("SELECT * FROM sixLinks")
    fun getAll() : Flow<List<SixLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSixLinks(sixLinks: SixLinks)

    @Delete
    suspend fun deleteSixLinks(sixLinks: SixLinks)

    @Query("DELETE FROM sixLinks")
    suspend fun deleteAll()
}

@Dao
interface SevenLinksDao {
    @Query("SELECT * FROM sevenLinks")
    fun getAll() : Flow<List<SevenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSevenLinks(sevenLinks: SevenLinks)

    @Delete
    suspend fun deleteSevenLinks(sevenLinks: SevenLinks)

    @Query("DELETE FROM sevenLinks")
    suspend fun deleteAll()
}

@Dao
interface EightLinksDao {
    @Query("SELECT * FROM eightLinks")
    fun getAll() : Flow<List<EightLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEightLinks(eightLinks: EightLinks)

    @Delete
    suspend fun deleteEightLinks(eightLinks: EightLinks)

    @Query("DELETE FROM eightLinks")
    suspend fun deleteAll()
}

@Dao
interface NineLinksDao {
    @Query("SELECT * FROM nineLinks")
    fun getAll() : Flow<List<NineLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNineLinks(nineLinks: NineLinks)

    @Delete
    suspend fun deleteNineLinks(nineLinks: NineLinks)

    @Query("DELETE FROM nineLinks")
    suspend fun deleteAll()
}

@Dao
interface TenLinksDao {
    @Query("SELECT * FROM tenLinks")
    fun getAll() : Flow<List<TenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTenLinks(tenLinks: TenLinks)

    @Delete
    suspend fun deleteTenLinks(tenLinks: TenLinks)

    @Query("DELETE FROM tenLinks")
    suspend fun deleteAll()
}

@Dao
interface ElevenLinksDao {
    @Query("SELECT * FROM elevenLinks")
    fun getAll() : Flow<List<ElevenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertElevenLinks(elevenLinks: ElevenLinks)

    @Delete
    suspend fun deleteElevenLinks(elevenLinks: ElevenLinks)

    @Query("DELETE FROM elevenLinks")
    suspend fun deleteAll()
}

@Dao
interface TwelveLinksDao {
    @Query("SELECT * FROM twelveLinks")
    fun getAll() : Flow<List<TwelveLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwelveLinks(twelveLinks: TwelveLinks)

    @Delete
    suspend fun deleteTwelveLinks(twelveLinks: TwelveLinks)

    @Query("DELETE FROM twelveLinks")
    suspend fun deleteAll()
}

@Dao
interface ThirteenLinksDao {
    @Query("SELECT * FROM thirteenLinks")
    fun getAll() : Flow<List<ThirteenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirteenLinks(thirteenLinks: ThirteenLinks)

    @Delete
    suspend fun deleteThirteenLinks(thirteenLinks: ThirteenLinks)

    @Query("DELETE FROM thirteenLinks")
    suspend fun deleteAll()
}

@Dao
interface FourteenLinksDao {
    @Query("SELECT * FROM fourteenLinks")
    fun getAll() : Flow<List<FourteenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFourteenLinks(fourteenLinks: FourteenLinks)

    @Delete
    suspend fun deleteFourteenLinks(fourteenLinks: FourteenLinks)

    @Query("DELETE FROM fourteenLinks")
    suspend fun deleteAll()
}

@Dao
interface FifteenLinksDao {
    @Query("SELECT * FROM fifteenLinks")
    fun getAll() : Flow<List<FifteenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFifteenLinks(fifteenLinks: FifteenLinks)

    @Delete
    suspend fun deleteFifteenLinks(fifteenLinks: FifteenLinks)

    @Query("DELETE FROM fifteenLinks")
    suspend fun deleteAll()
}

@Dao
interface SixteenLinksDao {
    @Query("SELECT * FROM sixteenLinks")
    fun getAll() : Flow<List<SixteenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSixteenLinks(sixteenLinks: SixteenLinks)

    @Delete
    suspend fun deleteSixteenLinks(sixteenLinks: SixteenLinks)

    @Query("DELETE FROM sixteenLinks")
    suspend fun deleteAll()
}

@Dao
interface SeventeenLinksDao {
    @Query("SELECT * FROM seventeenLinks")
    fun getAll() : Flow<List<SeventeenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeventeenLinks(seventeenLinks: SeventeenLinks)

    @Delete
    suspend fun deleteSeventeenLinks(seventeenLinks: SeventeenLinks)

    @Query("DELETE FROM seventeenLinks")
    suspend fun deleteAll()
}

@Dao
interface EighteenLinksDao {
    @Query("SELECT * FROM eighteenLinks")
    fun getAll() : Flow<List<EighteenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEighteenLinks(eighteenLinks: EighteenLinks)

    @Delete
    suspend fun deleteEighteenLinks(eighteenLinks: EighteenLinks)

    @Query("DELETE FROM eighteenLinks")
    suspend fun deleteAll()
}

@Dao
interface NineteenLinksDao {
    @Query("SELECT * FROM nineteenLinks")
    fun getAll() : Flow<List<NineteenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNineteenLinks(nineteenLinks: NineteenLinks)

    @Delete
    suspend fun deleteNineteenLinks(nineteenLinks: NineteenLinks)

    @Query("DELETE FROM nineteenLinks")
    suspend fun deleteAll()
}

@Dao
interface TwentyLinksDao {
    @Query("SELECT * FROM twentyLinks")
    fun getAll() : Flow<List<TwentyLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyLinks(twentyLinks: TwentyLinks)

    @Delete
    suspend fun deleteTwentyLinks(twentyLinks: TwentyLinks)

    @Query("DELETE FROM twentyLinks")
    suspend fun deleteAll()
}

@Dao
interface TwentyOneLinksDao {
    @Query("SELECT * FROM twentyOneLinks")
    fun getAll() : Flow<List<TwentyOneLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyOneLinks(twentyOneLinks: TwentyOneLinks)

    @Delete
    suspend fun deleteTwentyOneLinks(twentyOneLinks: TwentyOneLinks)

    @Query("DELETE FROM twentyOneLinks")
    suspend fun deleteAll()
}

@Dao
interface TwentyTwoLinksDao {
    @Query("SELECT * FROM twentyTwoLinks")
    fun getAll() : Flow<List<TwentyTwoLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyTwoLinks(twentyTwoLinks: TwentyTwoLinks)

    @Delete
    suspend fun deleteTwentyTwoLinks(twentyTwoLinks: TwentyTwoLinks)

    @Query("DELETE FROM twentyTwoLinks")
    suspend fun deleteAll()
}

@Dao
interface TwentyThreeLinksDao {
    @Query("SELECT * FROM twentyThreeLinks")
    fun getAll() : Flow<List<TwentyThreeLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyThreeLinks(twentyThreeLinks: TwentyThreeLinks)

    @Delete
    suspend fun deleteTwentyThreeLinks(twentyThreeLinks: TwentyThreeLinks)

    @Query("DELETE FROM twentyThreeLinks")
    suspend fun deleteAll()
}

@Dao
interface TwentyFourLinksDao {
    @Query("SELECT * FROM twentyFourLinks")
    fun getAll() : Flow<List<TwentyFourLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyFourLinks(twentyFourLinks: TwentyFourLinks)

    @Delete
    suspend fun deleteTwentyFourLinks(twentyFourLinks: TwentyFourLinks)

    @Query("DELETE FROM twentyFourLinks")
    suspend fun deleteAll()
}

@Dao
interface TwentyFiveLinksDao {
    @Query("SELECT * FROM twentyFiveLinks")
    fun getAll() : Flow<List<TwentyFiveLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyFiveLinks(twentyFiveLinks: TwentyFiveLinks)

    @Delete
    suspend fun deleteTwentyFiveLinks(twentyFiveLinks: TwentyFiveLinks)

    @Query("DELETE FROM twentyFiveLinks")
    suspend fun deleteAll()
}

@Dao
interface TwentySixLinksDao {
    @Query("SELECT * FROM twentySixLinks")
    fun getAll() : Flow<List<TwentySixLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentySixLinks(twentySixLinks: TwentySixLinks)

    @Delete
    suspend fun deleteTwentySixLinks(twentySixLinks: TwentySixLinks)

    @Query("DELETE FROM twentySixLinks")
    suspend fun deleteAll()
}

@Dao
interface TwentySevenLinksDao {
    @Query("SELECT * FROM twentySevenLinks")
    fun getAll(): Flow<List<TwentySevenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentySevenLinks(twentySevenLinks: TwentySevenLinks)

    @Delete
    suspend fun deleteTwentySevenLinks(twentySevenLinks: TwentySevenLinks)

    @Query("DELETE FROM twentySevenLinks")
    suspend fun deleteAll()
}

@Dao
interface TwentyEightLinksDao {
    @Query("SELECT * FROM twentyEightLinks")
    fun getAll(): Flow<List<TwentyEightLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyEightLinks(twentyEightLinks: TwentyEightLinks)

    @Delete
    suspend fun deleteTwentyEightLinks(twentyEightLinks: TwentyEightLinks)

    @Query("DELETE FROM twentyEightLinks")
    suspend fun deleteAll()
}

@Dao
interface TwentyNineLinksDao {
    @Query("SELECT * FROM twentyNineLinks")
    fun getAll(): Flow<List<TwentyNineLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyNineLinks(twentyNineLinks: TwentyNineLinks)

    @Delete
    suspend fun deleteTwentyNineLinks(twentyNineLinks: TwentyNineLinks)

    @Query("DELETE FROM twentyNineLinks")
    suspend fun deleteAll()
}

@Dao
interface ThirtyLinksDao {
    @Query("SELECT * FROM thirtyLinks")
    fun getAll(): Flow<List<ThirtyLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirtyLinks(thirtyLinks: ThirtyLinks)

    @Delete
    suspend fun deleteThirtyLinks(thirtyLinks: ThirtyLinks)

    @Query("DELETE FROM thirtyLinks")
    suspend fun deleteAll()
}