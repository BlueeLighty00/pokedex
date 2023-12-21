package com.example.pokedex.domain.models

import androidx.compose.ui.graphics.Color
import com.example.pokedex.R
import com.example.pokedex.ui.theme.BugType
import com.example.pokedex.ui.theme.DarkType
import com.example.pokedex.ui.theme.DragonType
import com.example.pokedex.ui.theme.ElectricType
import com.example.pokedex.ui.theme.FairyType
import com.example.pokedex.ui.theme.FightingType
import com.example.pokedex.ui.theme.FireType
import com.example.pokedex.ui.theme.FlyingType
import com.example.pokedex.ui.theme.GhostType
import com.example.pokedex.ui.theme.GrassType
import com.example.pokedex.ui.theme.GroundType
import com.example.pokedex.ui.theme.IceType
import com.example.pokedex.ui.theme.NormalType
import com.example.pokedex.ui.theme.PoisonType
import com.example.pokedex.ui.theme.PsychicType
import com.example.pokedex.ui.theme.RockType
import com.example.pokedex.ui.theme.SteelType
import com.example.pokedex.ui.theme.WaterType

enum class Types(val color: Color, val image: Int) {
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