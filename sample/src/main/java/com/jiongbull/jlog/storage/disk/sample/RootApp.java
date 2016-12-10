/*
 * Copyright 2016 JiongBull
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jiongbull.jlog.storage.disk.sample;

import android.annotation.SuppressLint;
import android.app.Application;

import com.jiongbull.jlog.Logger;
import com.jiongbull.jlog.storage.disk.DiskConfigs;
import com.jiongbull.jlog.storage.disk.DiskStorage;

/**
 * Root application.
 */
public class RootApp extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Logger sLogger;

    public static Logger getLogger() {
        return sLogger;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        DiskConfigs diskConfigs = DiskConfigs.Builder.newBuilder()
                /* Properties below are default value, you can modify them or not. */
                .setCapacity(20 * 1024 * 1024)
                .build();

        sLogger = Logger.Builder.newBuilder(getApplicationContext(), "jlog")
                .setWriteToFile(true)
                .setStorage(new DiskStorage(diskConfigs))
                .build();
    }
}