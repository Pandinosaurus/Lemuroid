package com.swordfish.lemuroid.app.mobile.shared.compose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.swordfish.lemuroid.app.utils.games.GameUtils
import com.swordfish.lemuroid.lib.library.db.entity.Game

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun GameCard(game: Game, onClick: () -> Unit) {
    val context = LocalContext.current
    val subtitle = remember(game.id) {
        GameUtils.getGameSubtitle(context, game)
    }

    ElevatedCard(
        modifier = Modifier.padding(8.dp),
        onClick = onClick,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            GameImage(game)
            GameTexts(game.title, subtitle)
        }
    }
}
