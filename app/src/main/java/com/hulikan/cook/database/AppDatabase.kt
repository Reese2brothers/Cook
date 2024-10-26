package com.hulikan.cook.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MainList::class, Favourites::class, One::class, Two::class, Three::class, Four::class, Five::class,
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
    TwentySevenLinks::class, TwentyEightLinks::class, TwentyNineLinks::class, ThirtyLinks::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mainListDao(): MainListDao
    abstract fun favouritesDao(): FavouritesDao
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