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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.models.Puppy
import com.example.androiddevchallenge.ui.components.PuppyDetail
import com.example.androiddevchallenge.ui.components.PuppyRow
import com.example.androiddevchallenge.ui.components.StaggeredVerticalGrid
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp(puppies)
        }
    }
}

@Composable
fun MyApp(puppies: List<Puppy>) {
    val navController = rememberNavController()
    MyTheme {
        NavHost(navController, startDestination = "home") {
            composable("home") { PuppyGridView(puppies = puppies, navController = navController) }
            composable(
                "puppy/{puppyId}",
                arguments = listOf(navArgument("puppyId") { type = NavType.IntType })
            ) { backstackEntry ->
                PuppyDetail(
                    puppyId = backstackEntry.arguments?.getInt("puppyId") ?: 0
                )
            }
        }
    }
}

@Composable
fun PuppyGridView(
    puppies: List<Puppy>,
    navController: NavHostController
) {
    LazyColumn {
        item {
            StaggeredVerticalGrid(maxColumnWidth = 200.dp) {
                for (puppy in puppies) {
                    PuppyRow(
                        puppy = puppy,
                        onClick = { navController.navigate("puppy/${puppy.id}") }
                    )
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(puppies)
    }
}

val puppies = listOf(
    Puppy(
        id = 1,
        name = "Savanah",
        breed = "Shepherd",
        age = "Baby",
        imageUrl = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50716352/4/?bust=1614748955&width=450",
        description = "Hi, my name is Savanah. I am about 3 months old and am a sweet girl. I probably will weigh..."
    ),
    Puppy(
        id = 2,
        name = "Ollie",
        breed = "Terrier",
        age = "Young",
        imageUrl = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50716186/2/crop/?bust=1614748687&width=450",
        description = "Ollie is a cute and spunky 4 year old terrier mix, weighing in at 22 pounds.   Ollie loves his foster..."
    ),
    Puppy(
        id = 3,
        name = "Sandy",
        breed = "Shepherd",
        age = "Baby",
        imageUrl = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50716329/1/?bust=1614747682&width=450",
        description = "Hi, my name is Sandy. I am about 3 months old and am a sweet girl. I probably will weigh..."
    ),
    Puppy(
        id = 4,
        name = "Hedwig Broadway",
        breed = "Chinese Crested Dog",
        age = "Adult",
        imageUrl = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50716333/1/?bust=1614748876&width=450",
        description = "3 yr old, 15 lb Chinese Crested Powder Puff Mix (DNA TEST PENDING) for ADOPTION"
    ),
    Puppy(
        id = 5,
        name = "Caramel",
        breed = "Shepherd",
        age = "Baby",
        imageUrl = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50716155/3/?bust=1614746578&width=450",
        description = "Hi, my name is Caramel. I am about 3 months old and am a sweet girl. I probably will weigh..."
    ),
    Puppy(
        id = 6,
        name = "Ann",
        breed = "Husky",
        age = "Adult",
        imageUrl = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50716313/1/?bust=1614747756&width=450",
        description = "Hi, I'm Ann! I'm a 2 year old husky mix and i'm hoping to find my forever home soon. My..."
    )
)
