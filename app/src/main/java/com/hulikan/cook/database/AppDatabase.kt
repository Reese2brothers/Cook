package com.hulikan.cook.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MainList::class, One::class, Two::class, Three::class, Four::class, Five::class,
    Six::class, Seven::class, Eight::class, Nine::class, Ten::class, Eleven::class, Twelve::class,
    Thirteen::class, Fourteen::class, Fifteen::class, Sixteen::class, Seventeen::class, Eighteen::class,
    Nineteen::class, Twenty::class, TwentyOne::class, TwentyTwo::class, TwentyThree::class, TwentyFour::class,
    TwentyFive::class, TwentySix::class, TwentySeven::class, TwentyEight::class, TwentyNine::class,
    Thirty::class, OneLinks::class, TwoLinks::class,ThreeLinks::class,
    FourLinks::class, FiveLinks::class, SixLinks::class, SevenLinks::class, EightLinks::class,
    NineLinks::class, TenLinks::class, ElevenLinks::class, TwelveLinks::class, ThirteenLinks::class,
    FourteenLinks::class, FifteenLinks::class, SixteenLinks::class, SeventeenLinks::class,
    EighteenLinks::class, NineteenLinks::class, TwentyLinks::class, TwentyOneLinks::class, TwentyTwoLinks::class,
    TwentyThreeLinks::class, TwentyFourLinks::class, TwentyFiveLinks::class, TwentySixLinks::class,
    TwentySevenLinks::class, TwentyEightLinks::class, TwentyNineLinks::class, ThirtyLinks::class,
    OneImages::class, TwoImages::class, ThreeImages::class, FourImages::class, FiveImages::class,
    SixImages::class, SevenImages::class, EightImages::class, NineImages::class, TenImages::class,
    ElevenImages::class, TwelveImages::class, ThirteenImages::class, FourteenImages::class, FifteenImages::class,
    SixteenImages::class, SeventeenImages::class, EighteenImages::class, NineteenImages::class, TwentyImages::class,
    TwentyOneImages::class, TwentyTwoImages::class, TwentyThreeImages::class, TwentyFourImages::class,
    TwentyFiveImages::class, TwentySixImages::class, TwentySevenImages::class, TwentyEightImages::class,
    TwentyNineImages::class, ThirtyImages::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mainListDao(): MainListDao
    abstract fun oneDao(): OneDao
    abstract fun twoDao(): TwoDao
    abstract fun threeDao(): ThreeDao
    abstract fun fourDao(): FourDao
    abstract fun fiveDao(): FiveDao
    abstract fun sixDao(): SixDao
    abstract fun sevenDao(): SevenDao
    abstract fun eightDao(): EightDao
    abstract fun nineDao(): NineDao
    abstract fun tenDao(): TenDao
    abstract fun elevenDao(): ElevenDao
    abstract fun twelveDao(): TwelveDao
    abstract fun thirteenDao(): ThirteenDao
    abstract fun fourteenDao(): FourteenDao
    abstract fun fifteenDao(): FifteenDao
    abstract fun sixteenDao(): SixteenDao
    abstract fun seventeenDao(): SeventeenDao
    abstract fun eighteenDao(): EighteenDao
    abstract fun nineteenDao(): NineteenDao
    abstract fun twentyDao(): TwentyDao
    abstract fun twentyOneDao(): TwentyOneDao
    abstract fun twentyTwoDao(): TwentyTwoDao
    abstract fun twentyThreeDao(): TwentyThreeDao
    abstract fun twentyFourDao(): TwentyFourDao
    abstract fun twentyFiveDao(): TwentyFiveDao
    abstract fun twentySixDao(): TwentySixDao
    abstract fun twentySevenDao(): TwentySevenDao
    abstract fun twentyEightDao(): TwentyEightDao
    abstract fun twentyNineDao(): TwentyNineDao
    abstract fun thirtyDao(): ThirtyDao
    abstract fun oneLinksDao(): OneLinksDao
    abstract fun twoLinksDao(): TwoLinksDao
    abstract fun threeLinksDao(): ThreeLinksDao
    abstract fun fourLinksDao(): FourLinksDao
    abstract fun fiveLinksDao(): FiveLinksDao
    abstract fun sixLinksDao(): SixLinksDao
    abstract fun sevenLinksDao(): SevenLinksDao
    abstract fun eightLinksDao(): EightLinksDao
    abstract fun nineLinksDao(): NineLinksDao
    abstract fun tenLinksDao(): TenLinksDao
    abstract fun elevenLinksDao(): ElevenLinksDao
    abstract fun twelveLinksDao(): TwelveLinksDao
    abstract fun thirteenLinksDao(): ThirteenLinksDao
    abstract fun fourteenLinksDao(): FourteenLinksDao
    abstract fun fifteenLinksDao(): FifteenLinksDao
    abstract fun sixteenLinksDao(): SixteenLinksDao
    abstract fun seventeenLinksDao(): SeventeenLinksDao
    abstract fun eighteenLinksDao(): EighteenLinksDao
    abstract fun nineteenLinksDao(): NineteenLinksDao
    abstract fun twentyLinksDao(): TwentyLinksDao
    abstract fun twentyOneLinksDao(): TwentyOneLinksDao
    abstract fun twentyTwoLinksDao(): TwentyTwoLinksDao
    abstract fun twentyThreeLinksDao(): TwentyThreeLinksDao
    abstract fun twentyFourLinksDao(): TwentyFourLinksDao
    abstract fun twentyFiveLinksDao(): TwentyFiveLinksDao
    abstract fun twentySixLinksDao(): TwentySixLinksDao
    abstract fun twentySevenLinksDao(): TwentySevenLinksDao
    abstract fun twentyEightLinksDao(): TwentyEightLinksDao
    abstract fun twentyNineLinksDao(): TwentyNineLinksDao
    abstract fun thirtyLinksDao(): ThirtyLinksDao
    abstract fun oneImagesDao(): OneImagesDao
    abstract fun twoImagesDao(): TwoImagesDao
    abstract fun threeImagesDao(): ThreeImagesDao
    abstract fun fourImagesDao(): FourImagesDao
    abstract fun fiveImagesDao(): FiveImagesDao
    abstract fun sixImagesDao(): SixImagesDao
    abstract fun sevenImagesDao(): SevenImagesDao
    abstract fun eightImagesDao(): EightImagesDao
    abstract fun nineImagesDao(): NineImagesDao
    abstract fun tenImagesDao(): TenImagesDao
    abstract fun elevenImagesDao(): ElevenImagesDao
    abstract fun twelveImagesDao(): TwelveImagesDao
    abstract fun thirteenImagesDao(): ThirteenImagesDao
    abstract fun fourteenImagesDao(): FourteenImagesDao
    abstract fun fifteenImagesDao(): FifteenImagesDao
    abstract fun sixteenImagesDao(): SixteenImagesDao
    abstract fun seventeenImagesDao(): SeventeenImagesDao
    abstract fun eighteenImagesDao(): EighteenImagesDao
    abstract fun nineteenImagesDao(): NineteenImagesDao
    abstract fun twentyImagesDao(): TwentyImagesDao
    abstract fun twentyOneImagesDao(): TwentyOneImagesDao
    abstract fun twentyTwoImagesDao(): TwentyTwoImagesDao
    abstract fun twentyThreeImagesDao(): TwentyThreeImagesDao
    abstract fun twentyFourImagesDao(): TwentyFourImagesDao
    abstract fun twentyFiveImagesDao(): TwentyFiveImagesDao
    abstract fun twentySixImagesDao(): TwentySixImagesDao
    abstract fun twentySevenImagesDao(): TwentySevenImagesDao
    abstract fun twentyEightImagesDao(): TwentyEightImagesDao
    abstract fun twentyNineImagesDao(): TwentyNineImagesDao
    abstract fun thirtyImagesDao(): ThirtyImagesDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}