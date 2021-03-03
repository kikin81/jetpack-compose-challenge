/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.models.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyRow(
    puppy: Puppy,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoilImage(
            data = puppy.imageUrl,
            contentDescription = "Puppy image",
            fadeIn = true,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            puppy.name,
            style = typography.h6
        )
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            Text(
                puppy.age,
                style = typography.body2,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                puppy.breed,
                style = typography.body2,
            )
        }
    }
}

@Preview("Light Theme")
@Composable
fun PuppyListPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            PuppyRow(
                Puppy(
                    "Bruce",
                    "Husky",
                    "Young",
                    "https://images.dog.ceo/breeds/ovcharka-caucasian/IMG_20190528_194200.jpg",
                    ""
                ),
                onClick = { }
            )
        }
    }
}
