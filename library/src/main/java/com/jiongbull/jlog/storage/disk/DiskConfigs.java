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

package com.jiongbull.jlog.storage.disk;

import android.support.annotation.NonNull;

/**
 * 用于存储日志的磁盘配置，.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class DiskConfigs {
    /** 日志默认的存储空间，20M. */
    private static final long DEFAULT_DISK_CAPACITY = 20971520;
    /** 日志的存储空间，单位byte. */
    private long mCapacity;
    private DiskConfigs(@NonNull Builder builder) {
        mCapacity = builder.mCapacity;
    }

    public long getCapacity() {
        return mCapacity;
    }

    public static class Builder {
        private long mCapacity;

        private Builder() {
            mCapacity = DEFAULT_DISK_CAPACITY;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder setCapacity(long capacity) {
            mCapacity = capacity;
            return this;
        }

        public DiskConfigs build() {
            return new DiskConfigs(this);
        }
    }
}