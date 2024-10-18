package com.hulikan.cook.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface OneImagesDao {
    @Query("SELECT * FROM oneImages")
    fun getAll() : Flow<List<OneImages>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneImages(oneImages: OneImages)
    @Delete
    suspend fun deleteOneImages(oneImages: OneImages)
    @Query("DELETE FROM oneImages")
    suspend fun deleteAll()
}

@Dao
interface TwoImagesDao {
    @Query("SELECT * FROM twoImages")
    fun getAll() : Flow<List<TwoImages>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwoImages(twoImages: TwoImages)
    @Delete
    suspend fun deleteTwoImages(twoImages: TwoImages)
    @Query("DELETE FROM twoImages")
    suspend fun deleteAll()
}

@Dao
interface ThreeImagesDao {
    @Query("SELECT * FROM threeImages")
    fun getAll() : Flow<List<ThreeImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThreeImages(threeImages: ThreeImages)

    @Delete
    suspend fun deleteThreeImages(threeImages: ThreeImages)

    @Query("DELETE FROM threeImages")
    suspend fun deleteAll()
}

@Dao
interface FourImagesDao {
    @Query("SELECT * FROM fourImages")
    fun getAll() : Flow<List<FourImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFourImages(fourImages: FourImages)

    @Delete
    suspend fun deleteFourImages(fourImages: FourImages)

    @Query("DELETE FROM fourImages")
    suspend fun deleteAll()
}

@Dao
interface FiveImagesDao {
    @Query("SELECT * FROM fiveImages")
    fun getAll() : Flow<List<FiveImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFiveImages(fiveImages: FiveImages)

    @Delete
    suspend fun deleteFiveImages(fiveImages: FiveImages)

    @Query("DELETE FROM fiveImages")
    suspend fun deleteAll()
}

@Dao
interface SixImagesDao {
    @Query("SELECT * FROM sixImages")
    fun getAll() : Flow<List<SixImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSixImages(sixImages: SixImages)

    @Delete
    suspend fun deleteSixImages(sixImages: SixImages)

    @Query("DELETE FROM sixImages")
    suspend fun deleteAll()
}

@Dao
interface SevenImagesDao {
    @Query("SELECT * FROM sevenImages")
    fun getAll() : Flow<List<SevenImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSevenImages(sevenImages: SevenImages)

    @Delete
    suspend fun deleteSevenImages(sevenImages: SevenImages)

    @Query("DELETE FROM sevenImages")
    suspend fun deleteAll()
}

@Dao
interface EightImagesDao {
    @Query("SELECT * FROM eightImages")
    fun getAll() : Flow<List<EightImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEightImages(eightImages: EightImages)

    @Delete
    suspend fun deleteEightImages(eightImages: EightImages)

    @Query("DELETE FROM eightImages")
    suspend fun deleteAll()
}

@Dao
interface NineImagesDao {
    @Query("SELECT * FROM nineImages")
    fun getAll() : Flow<List<NineImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNineImages(nineImages: NineImages)

    @Delete
    suspend fun deleteNineImages(nineImages: NineImages)

    @Query("DELETE FROM nineImages")
    suspend fun deleteAll()
}

@Dao
interface TenImagesDao {
    @Query("SELECT * FROM tenImages")
    fun getAll() : Flow<List<TenImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTenImages(tenImages: TenImages)

    @Delete
    suspend fun deleteTenImages(tenImages: TenImages)

    @Query("DELETE FROM tenImages")
    suspend fun deleteAll()
}

@Dao
interface ElevenImagesDao {
    @Query("SELECT * FROM elevenImages")
    fun getAll() : Flow<List<ElevenImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertElevenImages(elevenImages: ElevenImages)

    @Delete
    suspend fun deleteElevenImages(elevenImages: ElevenImages)

    @Query("DELETE FROM elevenImages")
    suspend fun deleteAll()
}

@Dao
interface TwelveImagesDao {
    @Query("SELECT * FROM twelveImages")
    fun getAll() : Flow<List<TwelveImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwelveImages(twelveImages: TwelveImages)

    @Delete
    suspend fun deleteTwelveImages(twelveImages: TwelveImages)

    @Query("DELETE FROM twelveImages")
    suspend fun deleteAll()
}

@Dao
interface ThirteenImagesDao {
    @Query("SELECT * FROM thirteenImages")
    fun getAll() : Flow<List<ThirteenImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirteenImages(thirteenImages: ThirteenImages)

    @Delete
    suspend fun deleteThirteenImages(thirteenImages: ThirteenImages)

    @Query("DELETE FROM thirteenImages")
    suspend fun deleteAll()
}

@Dao
interface FourteenImagesDao {
    @Query("SELECT * FROM fourteenImages")
    fun getAll() : Flow<List<FourteenImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFourteenImages(fourteenImages: FourImages)

    @Delete
    suspend fun deleteFourteenImages(fourteenImages: FourImages)

    @Query("DELETE FROM fourteenImages")
    suspend fun deleteAll()
}

@Dao
interface FifteenImagesDao {
    @Query("SELECT * FROM fifteenImages")
    fun getAll() : Flow<List<FifteenImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFifteenImages(fifteenImages: FifteenImages)

    @Delete
    suspend fun deleteFifteenImages(fifteenImages: FifteenImages)

    @Query("DELETE FROM fifteenImages")
    suspend fun deleteAll()
}

@Dao
interface SixteenImagesDao {
    @Query("SELECT * FROM sixteenImages")
    fun getAll() : Flow<List<SixteenImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSixteenImages(sixteenImages: SixteenImages)

    @Delete
    suspend fun deleteSixteenImages(sixteenImages: SixteenImages)

    @Query("DELETE FROM sixteenImages")
    suspend fun deleteAll()
}

@Dao
interface SeventeenImagesDao {
    @Query("SELECT * FROM seventeenImages")
    fun getAll() : Flow<List<SeventeenImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeventeenImages(seventeenImages: SeventeenImages)

    @Delete
    suspend fun deleteSeventeenImages(seventeenImages: SeventeenImages)

    @Query("DELETE FROM seventeenImages")
    suspend fun deleteAll()
}

@Dao
interface EighteenImagesDao {
    @Query("SELECT * FROM eighteenImages")
    fun getAll() : Flow<List<EighteenImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEighteenImages(eighteenImages: EighteenImages)

    @Delete
    suspend fun deleteEighteenImages(eighteenImages: EighteenImages)

    @Query("DELETE FROM eighteenImages")
    suspend fun deleteAll()
}

@Dao
interface NineteenImagesDao {
    @Query("SELECT * FROM nineteenImages")
    fun getAll() : Flow<List<NineteenImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNineteenImages(nineteenImages: NineteenImages)

    @Delete
    suspend fun deleteNineteenImages(nineteenImages: NineteenImages)

    @Query("DELETE FROM nineteenImages")
    suspend fun deleteAll()
}

@Dao
interface TwentyImagesDao {
    @Query("SELECT * FROM twentyImages")
    fun getAll() : Flow<List<TwentyImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyImages(twentyImages: TwentyImages)

    @Delete
    suspend fun deleteTwentyImages(twentyImages: TwentyImages)

    @Query("DELETE FROM twentyImages")
    suspend fun deleteAll()
}

@Dao
interface TwentyOneImagesDao {
    @Query("SELECT * FROM twentyOneImages")
    fun getAll() : Flow<List<TwentyOneImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyOneImages(twentyOneImages: TwentyOneImages)

    @Delete
    suspend fun deleteTwentyOneImages(twentyOneImages: TwentyOneImages)

    @Query("DELETE FROM twentyOneImages")
    suspend fun deleteAll()
}

@Dao
interface TwentyTwoImagesDao {
    @Query("SELECT * FROM twentyTwoImages")
    fun getAll() : Flow<List<TwentyTwoImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyTwoImages(twentyTwoImages: TwentyTwoImages)

    @Delete
    suspend fun deleteTwentyTwoImages(twentyTwoImages: TwentyTwoImages)

    @Query("DELETE FROM twentyTwoImages")
    suspend fun deleteAll()
}

@Dao
interface TwentyThreeImagesDao {
    @Query("SELECT * FROM twentyThreeImages")
    fun getAll() : Flow<List<TwentyThreeImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyThreeImages(twentyThreeImages: TwentyThreeImages)

    @Delete
    suspend fun deleteTwentyThreeImages(twentyThreeImages: TwentyThreeImages)

    @Query("DELETE FROM twentyThreeImages")
    suspend fun deleteAll()
}

@Dao
interface TwentyFourImagesDao {
    @Query("SELECT * FROM twentyFourImages")
    fun getAll(): Flow<List<TwentyFourImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyFourImages(twentyFourImages: TwentyFourImages)

    @Delete
    suspend fun deleteTwentyFourImages(twentyFourImages: TwentyFourImages)

    @Query("DELETE FROM twentyFourImages")
    suspend fun deleteAll()
}

@Dao
interface TwentyFiveImagesDao {
    @Query("SELECT * FROM twentyFiveImages")
    fun getAll(): Flow<List<TwentyFiveImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyFiveImages(twentyFiveImages: TwentyFiveImages)

    @Delete
    suspend fun deleteTwentyFiveImages(twentyFiveImages: TwentyFiveImages)

    @Query("DELETE FROM twentyFiveImages")
    suspend fun deleteAll()
}

@Dao
interface TwentySixImagesDao {
    @Query("SELECT * FROM twentySixImages")
    fun getAll(): Flow<List<TwentySixImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentySixImages(twentySixImages: TwentySixImages)

    @Delete
    suspend fun deleteTwentySixImages(twentySixImages: TwentySixImages)

    @Query("DELETE FROM twentySixImages")
    suspend fun deleteAll()
}

@Dao
interface TwentySevenImagesDao {
    @Query("SELECT * FROM twentySevenImages")
    fun getAll(): Flow<List<TwentySevenImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentySevenImages(twentySevenImages: TwentySevenImages)

    @Delete
    suspend fun deleteTwentySevenImages(twentySevenImages: TwentySevenImages)

    @Query("DELETE FROM twentySevenImages")
    suspend fun deleteAll()
}

@Dao
interface TwentyEightImagesDao {
    @Query("SELECT * FROM twentyEightImages")
    fun getAll(): Flow<List<TwentyEightImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyEightImages(twentyEightImages: TwentyEightImages)

    @Delete
    suspend fun deleteTwentyEightImages(twentyEightImages: TwentyEightImages)

    @Query("DELETE FROM twentyEightImages")
    suspend fun deleteAll()
}

@Dao
interface TwentyNineImagesDao {
    @Query("SELECT * FROM twentyNineImages")
    fun getAll(): Flow<List<TwentyNineImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTwentyNineImages(twentyNineImages: TwentyNineImages)

    @Delete
    suspend fun deleteTwentyNineImages(twentyNineImages: TwentyNineImages)

    @Query("DELETE FROM twentyNineImages")
    suspend fun deleteAll()
}

@Dao
interface ThirtyImagesDao {
    @Query("SELECT * FROM thirtyImages")
    fun getAll(): Flow<List<ThirtyImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThirtyImages(thirtyImages: ThirtyImages)

    @Delete
    suspend fun deleteThirtyImages(thirtyImages: ThirtyImages)

    @Query("DELETE FROM thirtyImages")
    suspend fun deleteAll()
}