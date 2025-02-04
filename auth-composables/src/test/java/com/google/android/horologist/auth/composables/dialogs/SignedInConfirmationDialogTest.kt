/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:OptIn(
    ExperimentalHorologistPaparazziApi::class,
    ExperimentalHorologistAuthComposablesApi::class
)

package com.google.android.horologist.auth.composables.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.android.horologist.auth.composables.ExperimentalHorologistAuthComposablesApi
import com.google.android.horologist.compose.tools.coil.FakeImageLoader
import com.google.android.horologist.paparazzi.ExperimentalHorologistPaparazziApi
import com.google.android.horologist.paparazzi.WearPaparazzi
import org.junit.Rule
import org.junit.Test

class SignedInConfirmationDialogTest {

    @get:Rule
    val paparazzi = WearPaparazzi()

    @Test
    fun signedInConfirmationDialog() {
        paparazzi.snapshot {
            FakeImageLoader.Resources.override {
                Box(
                    modifier = Modifier.background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    SignedInConfirmationDialogContent(
                        displayName = "Maggie",
                        email = "maggie@example.com",
                        avatar = android.R.drawable.sym_def_app_icon
                    )
                }
            }
        }
    }

    @Test
    fun signedInConfirmationDialogNoName() {
        paparazzi.snapshot {
            FakeImageLoader.Resources.override {
                Box(
                    modifier = Modifier.background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    SignedInConfirmationDialogContent(
                        email = "maggie@example.com",
                        avatar = android.R.drawable.sym_def_app_icon
                    )
                }
            }
        }
    }

    @Test
    fun signedInConfirmationDialogNoNameNoAvatar() {
        paparazzi.snapshot {
            Box(
                modifier = Modifier.background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                SignedInConfirmationDialogContent(
                    email = "maggie@example.com"
                )
            }
        }
    }

    @Test
    fun signedInConfirmationDialogNoEmail() {
        paparazzi.snapshot {
            FakeImageLoader.Resources.override {
                Box(
                    modifier = Modifier.background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    SignedInConfirmationDialogContent(
                        displayName = "Maggie",
                        avatar = android.R.drawable.sym_def_app_icon
                    )
                }
            }
        }
    }

    @Test
    fun signedInConfirmationDialogNoInformation() {
        paparazzi.snapshot {
            Box(
                modifier = Modifier.background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                SignedInConfirmationDialogContent()
            }
        }
    }

    @Test
    fun signedInConfirmationDialogTruncation() {
        paparazzi.snapshot {
            FakeImageLoader.Resources.override {
                Box(
                    modifier = Modifier.background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    SignedInConfirmationDialogContent(
                        displayName = "Wolfeschlegelsteinhausenbergerdorff",
                        email = "wolfeschlegelsteinhausenbergerdorff@example.com",
                        avatar = android.R.drawable.sym_def_app_icon
                    )
                }
            }
        }
    }
}
