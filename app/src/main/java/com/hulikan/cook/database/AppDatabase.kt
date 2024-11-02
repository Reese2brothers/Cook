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
    Thirty::class, ThirtyOne::class,
    ThirtyTwo::class, ThirtyThree::class, ThirtyFour::class, ThirtyFive::class, ThirtySix::class,
    ThirtySeven::class, ThirtyEight::class, ThirtyNine::class, Forty::class, FortyOne::class,
    FortyTwo::class, FortyThree::class, FortyFour::class, FortyFive::class, FortySix::class,
    FortySeven::class, FortyEight::class, FortyNine::class,
    Fifty::class, OneLinks::class, TwoLinks::class,ThreeLinks::class,
    FourLinks::class, FiveLinks::class, SixLinks::class, SevenLinks::class, EightLinks::class,
    NineLinks::class, TenLinks::class, ElevenLinks::class, TwelveLinks::class, ThirteenLinks::class,
    FourteenLinks::class, FifteenLinks::class, SixteenLinks::class, SeventeenLinks::class,
    EighteenLinks::class, NineteenLinks::class, TwentyLinks::class, TwentyOneLinks::class, TwentyTwoLinks::class,
    TwentyThreeLinks::class, TwentyFourLinks::class, TwentyFiveLinks::class, TwentySixLinks::class,
    TwentySevenLinks::class, TwentyEightLinks::class, TwentyNineLinks::class, ThirtyLinks::class,
    ThirtyOneLinks::class, ThirtyTwoLinks::class, ThirtyThreeLinks::class, ThirtyFourLinks::class, ThirtyFiveLinks::class,
    ThirtySixLinks::class, ThirtySevenLinks::class, ThirtyEightLinks::class, ThirtyNineLinks::class,
    FortyLinks::class, FortyOneLinks::class, FortyTwoLinks::class, FortyThreeLinks::class,
    FortyFourLinks::class, FortyFiveLinks::class, FortySixLinks::class, FortySevenLinks::class,
    FortyEightLinks::class, FortyNineLinks::class, FiftyLinks::class], version = 1)
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
    abstract fun thirtyOneDao(): ThirtyOneDao
    abstract fun thirtyTwoDao(): ThirtyTwoDao
    abstract fun thirtyThreeDao(): ThirtyThreeDao
    abstract fun thirtyFourDao(): ThirtyFourDao
    abstract fun thirtyFiveDao(): ThirtyFiveDao
    abstract fun thirtySixDao(): ThirtySixDao
    abstract fun thirtySevenDao(): ThirtySevenDao
    abstract fun thirtyEightDao(): ThirtyEightDao
    abstract fun thirtyNineDao(): ThirtyNineDao
    abstract fun fortyDao(): FortyDao
    abstract fun fortyOneDao(): FortyOneDao
    abstract fun fortyTwoDao(): FortyTwoDao
    abstract fun fortyThreeDao(): FortyThreeDao
    abstract fun fortyFourDao(): FortyFourDao
    abstract fun fortyFiveDao(): FortyFiveDao
    abstract fun fortySixDao(): FortySixDao
    abstract fun fortySevenDao(): FortySevenDao
    abstract fun fortyEightDao(): FortyEightDao
    abstract fun fortyNineDao(): FortyNineDao
    abstract fun fiftyDao(): FiftyDao
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
    abstract fun thirtyOneLinksDao(): ThirtyOneLinksDao
    abstract fun thirtyTwoLinksDao(): ThirtyTwoLinksDao
    abstract fun thirtyThreeLinksDao(): ThirtyThreeLinksDao
    abstract fun thirtyFourLinksDao(): ThirtyFourLinksDao
    abstract fun thirtyFiveLinksDao(): ThirtyFiveLinksDao
    abstract fun thirtySixLinksDao(): ThirtySixLinksDao
    abstract fun thirtySevenLinksDao(): ThirtySevenLinksDao
    abstract fun thirtyEightLinksDao(): ThirtyEightLinksDao
    abstract fun thirtyNineLinksDao(): ThirtyNineLinksDao
    abstract fun fortyLinksDao(): FortyLinksDao
    abstract fun fortyOneLinksDao(): FortyOneLinksDao
    abstract fun fortyTwoLinksDao(): FortyTwoLinksDao
    abstract fun fortyThreeLinksDao(): FortyThreeLinksDao
    abstract fun fortyFourLinksDao(): FortyFourLinksDao
    abstract fun fortyFiveLinksDao(): FortyFiveLinksDao
    abstract fun fortySixLinksDao(): FortySixLinksDao
    abstract fun fortySevenLinksDao(): FortySevenLinksDao
    abstract fun fortyEightLinksDao(): FortyEightLinksDao
    abstract fun fortyNineLinksDao(): FortyNineLinksDao
    abstract fun fiftyLinksDao(): FiftyLinksDao

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