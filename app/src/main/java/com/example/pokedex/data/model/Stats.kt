package com.example.pokedex.data.model

import androidx.compose.ui.graphics.Color
import com.example.pokedex.ui.theme.*

enum class Stats(val stat: String, val color: Color) {
    HP("HP", HPStat),
    ATK("ATK", ATKStat),
    DEF("DEF", DEFStat),
    SPATK("SP.ATK", SPATKStat),
    SPDEF("SP.DEF", SPDEFStat),
    SPD("SPD", SPDStat)
}