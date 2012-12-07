package org.zhaobudao.mist.util;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;
import org.zhaobudao.mist.util.CryptoUtil;

public class CryptoUtilTest {

    @Test
    public void testDigest() throws NoSuchAlgorithmException {
        assertEquals("bf9661defa3daecacfde5bde0214c4a439351d4d", CryptoUtil.digest("sss"));
    }

    @Test
    public void testByte2hex() throws NoSuchAlgorithmException {
        assertEquals("", CryptoUtil.byte2hex(null));
    }

}
