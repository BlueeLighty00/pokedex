package com.example.pokedex.data.model

import androidx.compose.ui.graphics.Color
import com.example.pokedex.R
import com.example.pokedex.ui.theme.*

enum class Types(val color: Color,val image: Int) {
    NORMAL(NormalType, R.drawable.normalbackground),
    FIRE(FireType, R.drawable.firebackground),
    WATER(WaterType, R.drawable.waterbackground),
    FLYING(FlyingType, R.drawable.flyingbackground),
    ELECTRIC(ElectricType, R.drawable.electricbackground),
    GRASS(GrassType, R.drawable.grassbackground),
    ICE(IceType, R.drawable.icebackground),
    FIGHTING(FightingType, R.drawable.fightbackground),
    POISON(PoisonType, R.drawable.poisonbackground),
    GROUND(GroundType, R.drawable.groundbackground),
    PSYCHIC(PsychicType, R.drawable.psychicbackground),
    BUG(BugType, R.drawable.bugbackground),
    ROCK(RockType, R.drawable.rockbackground),
    GHOST(GhostType, R.drawable.ghostbackground),
    DRAGON(DragonType, R.drawable.dragonbackground),
    DARK(DarkType, R.drawable.darkbackground),
    STEEL(SteelType, R.drawable.steelbackground),
    FAIRY(FairyType, R.drawable.fairybackground)
}