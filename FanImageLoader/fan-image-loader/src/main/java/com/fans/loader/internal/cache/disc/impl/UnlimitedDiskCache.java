/*******************************************************************************
 * Copyright 2011-2014 Sergey Tarasevich
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.fans.loader.internal.cache.disc.impl;

import java.io.File;

/**
 * Cache size is unlimited.
 *
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 * @since 1.0.0
 */
public class UnlimitedDiskCache extends BaseDiskCache {
    /** @param cacheDir Directory for file caching */
    public UnlimitedDiskCache(File cacheDir) {
        super(cacheDir);
    }

    /**
     * @param cacheDir        Directory for file caching
     * @param reserveCacheDir null-ok; Reserve directory for file caching. It's used when the primary directory isn't available.
     */
    public UnlimitedDiskCache(File cacheDir, File reserveCacheDir) {
        super(cacheDir, reserveCacheDir);
    }

}
