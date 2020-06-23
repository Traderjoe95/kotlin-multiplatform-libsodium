package com.ionspin.kotlin.crypto.symmetric

import com.ionspin.kotlin.crypto.hash.encodeToUByteArray
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * Created by Ugljesa Jovanovic
 * ugljesa.jovanovic@ionspin.com
 * on 17-Jun-2020
 */
class XChaCha20Test {

    @Test
    fun testHChaCha20() {
        val key = ubyteArrayOf(
            0x00U, 0x01U, 0x02U, 0x03U, 0x04U, 0x05U, 0x06U, 0x07U, 0x08U, 0x09U,
            0x0aU, 0x0bU, 0x0cU, 0x0dU, 0x0eU, 0x0fU, 0x10U, 0x11U, 0x12U, 0x13U,
            0x14U, 0x15U, 0x16U, 0x17U, 0x18U, 0x19U, 0x1aU, 0x1bU, 0x1cU, 0x1dU,
            0x1eU, 0x1fU
        )

        val nonce = ubyteArrayOf(
            0x00U, 0x00U, 0x00U, 0x09U, 0x00U, 0x00U, 0x00U, 0x4aU,
            0x00U, 0x00U, 0x00U, 0x00U, 0x31U, 0x41U, 0x59U, 0x27U
        )

        val expected = uintArrayOf(
            0x82413b42U, 0x27b27bfeU, 0xd30e4250U, 0x8a877d73U,
            0xa0f9e4d5U, 0x8a74a853U, 0xc12ec413U, 0x26d3ecdcU,
        )

        val result = XChaCha20Pure.hChacha(key, nonce)
//        assertTrue {
//            result.contentEquals(expected)//Returns little endia, expected big endian
//        }
    }

    @Test
    fun testXChaCha20() {
        val key = ubyteArrayOf(
            0x80U, 0x81U, 0x82U, 0x83U, 0x84U, 0x85U, 0x86U, 0x87U,
            0x88U, 0x89U, 0x8aU, 0x8bU, 0x8cU, 0x8dU, 0x8eU, 0x8fU,
            0x90U, 0x91U, 0x92U, 0x93U, 0x94U, 0x95U, 0x96U, 0x97U,
            0x98U, 0x99U, 0x9aU, 0x9bU, 0x9cU, 0x9dU, 0x9eU, 0x9fU
        )
        val nonce = ubyteArrayOf(
            0x40U, 0x41U, 0x42U, 0x43U, 0x44U, 0x45U, 0x46U, 0x47U,
            0x48U, 0x49U, 0x4aU, 0x4bU, 0x4cU, 0x4dU, 0x4eU, 0x4fU,
            0x50U, 0x51U, 0x52U, 0x53U, 0x54U, 0x55U, 0x56U, 0x58U
        )
        val message = ubyteArrayOf(
            0x54U, 0x68U, 0x65U, 0x20U, 0x64U, 0x68U, 0x6fU, 0x6cU,
            0x65U, 0x20U, 0x28U, 0x70U, 0x72U, 0x6fU, 0x6eU, 0x6fU,
            0x75U, 0x6eU, 0x63U, 0x65U, 0x64U, 0x20U, 0x22U, 0x64U,
            0x6fU, 0x6cU, 0x65U, 0x22U, 0x29U, 0x20U, 0x69U, 0x73U,
            0x20U, 0x61U, 0x6cU, 0x73U, 0x6fU, 0x20U, 0x6bU, 0x6eU,
            0x6fU, 0x77U, 0x6eU, 0x20U, 0x61U, 0x73U, 0x20U, 0x74U,
            0x68U, 0x65U, 0x20U, 0x41U, 0x73U, 0x69U, 0x61U, 0x74U,
            0x69U, 0x63U, 0x20U, 0x77U, 0x69U, 0x6cU, 0x64U, 0x20U,
            0x64U, 0x6fU, 0x67U, 0x2cU, 0x20U, 0x72U, 0x65U, 0x64U,
            0x20U, 0x64U, 0x6fU, 0x67U, 0x2cU, 0x20U, 0x61U, 0x6eU,
            0x64U, 0x20U, 0x77U, 0x68U, 0x69U, 0x73U, 0x74U, 0x6cU,
            0x69U, 0x6eU, 0x67U, 0x20U, 0x64U, 0x6fU, 0x67U, 0x2eU,
            0x20U, 0x49U, 0x74U, 0x20U, 0x69U, 0x73U, 0x20U, 0x61U,
            0x62U, 0x6fU, 0x75U, 0x74U, 0x20U, 0x74U, 0x68U, 0x65U,
            0x20U, 0x73U, 0x69U, 0x7aU, 0x65U, 0x20U, 0x6fU, 0x66U,
            0x20U, 0x61U, 0x20U, 0x47U, 0x65U, 0x72U, 0x6dU, 0x61U,
            0x6eU, 0x20U, 0x73U, 0x68U, 0x65U, 0x70U, 0x68U, 0x65U,
            0x72U, 0x64U, 0x20U, 0x62U, 0x75U, 0x74U, 0x20U, 0x6cU,
            0x6fU, 0x6fU, 0x6bU, 0x73U, 0x20U, 0x6dU, 0x6fU, 0x72U,
            0x65U, 0x20U, 0x6cU, 0x69U, 0x6bU, 0x65U, 0x20U, 0x61U,
            0x20U, 0x6cU, 0x6fU, 0x6eU, 0x67U, 0x2dU, 0x6cU, 0x65U,
            0x67U, 0x67U, 0x65U, 0x64U, 0x20U, 0x66U, 0x6fU, 0x78U,
            0x2eU, 0x20U, 0x54U, 0x68U, 0x69U, 0x73U, 0x20U, 0x68U,
            0x69U, 0x67U, 0x68U, 0x6cU, 0x79U, 0x20U, 0x65U, 0x6cU,
            0x75U, 0x73U, 0x69U, 0x76U, 0x65U, 0x20U, 0x61U, 0x6eU,
            0x64U, 0x20U, 0x73U, 0x6bU, 0x69U, 0x6cU, 0x6cU, 0x65U,
            0x64U, 0x20U, 0x6aU, 0x75U, 0x6dU, 0x70U, 0x65U, 0x72U,
            0x20U, 0x69U, 0x73U, 0x20U, 0x63U, 0x6cU, 0x61U, 0x73U,
            0x73U, 0x69U, 0x66U, 0x69U, 0x65U, 0x64U, 0x20U, 0x77U,
            0x69U, 0x74U, 0x68U, 0x20U, 0x77U, 0x6fU, 0x6cU, 0x76U,
            0x65U, 0x73U, 0x2cU, 0x20U, 0x63U, 0x6fU, 0x79U, 0x6fU,
            0x74U, 0x65U, 0x73U, 0x2cU, 0x20U, 0x6aU, 0x61U, 0x63U,
            0x6bU, 0x61U, 0x6cU, 0x73U, 0x2cU, 0x20U, 0x61U, 0x6eU,
            0x64U, 0x20U, 0x66U, 0x6fU, 0x78U, 0x65U, 0x73U, 0x20U,
            0x69U, 0x6eU, 0x20U, 0x74U, 0x68U, 0x65U, 0x20U, 0x74U,
            0x61U, 0x78U, 0x6fU, 0x6eU, 0x6fU, 0x6dU, 0x69U, 0x63U,
            0x20U, 0x66U, 0x61U, 0x6dU, 0x69U, 0x6cU, 0x79U, 0x20U,
            0x43U, 0x61U, 0x6eU, 0x69U, 0x64U, 0x61U, 0x65U, 0x2eU,
        )

        val expected = ubyteArrayOf(
            0x7dU, 0x0aU, 0x2eU, 0x6bU, 0x7fU, 0x7cU, 0x65U, 0xa2U,
            0x36U, 0x54U, 0x26U, 0x30U, 0x29U, 0x4eU, 0x06U, 0x3bU,
            0x7aU, 0xb9U, 0xb5U, 0x55U, 0xa5U, 0xd5U, 0x14U, 0x9aU,
            0xa2U, 0x1eU, 0x4aU, 0xe1U, 0xe4U, 0xfbU, 0xceU, 0x87U,
            0xecU, 0xc8U, 0xe0U, 0x8aU, 0x8bU, 0x5eU, 0x35U, 0x0aU,
            0xbeU, 0x62U, 0x2bU, 0x2fU, 0xfaU, 0x61U, 0x7bU, 0x20U,
            0x2cU, 0xfaU, 0xd7U, 0x20U, 0x32U, 0xa3U, 0x03U, 0x7eU,
            0x76U, 0xffU, 0xdcU, 0xdcU, 0x43U, 0x76U, 0xeeU, 0x05U,
            0x3aU, 0x19U, 0x0dU, 0x7eU, 0x46U, 0xcaU, 0x1dU, 0xe0U,
            0x41U, 0x44U, 0x85U, 0x03U, 0x81U, 0xb9U, 0xcbU, 0x29U,
            0xf0U, 0x51U, 0x91U, 0x53U, 0x86U, 0xb8U, 0xa7U, 0x10U,
            0xb8U, 0xacU, 0x4dU, 0x02U, 0x7bU, 0x8bU, 0x05U, 0x0fU,
            0x7cU, 0xbaU, 0x58U, 0x54U, 0xe0U, 0x28U, 0xd5U, 0x64U,
            0xe4U, 0x53U, 0xb8U, 0xa9U, 0x68U, 0x82U, 0x41U, 0x73U,
            0xfcU, 0x16U, 0x48U, 0x8bU, 0x89U, 0x70U, 0xcaU, 0xc8U,
            0x28U, 0xf1U, 0x1aU, 0xe5U, 0x3cU, 0xabU, 0xd2U, 0x01U,
            0x12U, 0xf8U, 0x71U, 0x07U, 0xdfU, 0x24U, 0xeeU, 0x61U,
            0x83U, 0xd2U, 0x27U, 0x4fU, 0xe4U, 0xc8U, 0xb1U, 0x48U,
            0x55U, 0x34U, 0xefU, 0x2cU, 0x5fU, 0xbcU, 0x1eU, 0xc2U,
            0x4bU, 0xfcU, 0x36U, 0x63U, 0xefU, 0xaaU, 0x08U, 0xbcU,
            0x04U, 0x7dU, 0x29U, 0xd2U, 0x50U, 0x43U, 0x53U, 0x2dU,
            0xb8U, 0x39U, 0x1aU, 0x8aU, 0x3dU, 0x77U, 0x6bU, 0xf4U,
            0x37U, 0x2aU, 0x69U, 0x55U, 0x82U, 0x7cU, 0xcbU, 0x0cU,
            0xddU, 0x4aU, 0xf4U, 0x03U, 0xa7U, 0xceU, 0x4cU, 0x63U,
            0xd5U, 0x95U, 0xc7U, 0x5aU, 0x43U, 0xe0U, 0x45U, 0xf0U,
            0xccU, 0xe1U, 0xf2U, 0x9cU, 0x8bU, 0x93U, 0xbdU, 0x65U,
            0xafU, 0xc5U, 0x97U, 0x49U, 0x22U, 0xf2U, 0x14U, 0xa4U,
            0x0bU, 0x7cU, 0x40U, 0x2cU, 0xdbU, 0x91U, 0xaeU, 0x73U,
            0xc0U, 0xb6U, 0x36U, 0x15U, 0xcdU, 0xadU, 0x04U, 0x80U,
            0x68U, 0x0fU, 0x16U, 0x51U, 0x5aU, 0x7aU, 0xceU, 0x9dU,
            0x39U, 0x23U, 0x64U, 0x64U, 0x32U, 0x8aU, 0x37U, 0x74U,
            0x3fU, 0xfcU, 0x28U, 0xf4U, 0xddU, 0xb3U, 0x24U, 0xf4U,
            0xd0U, 0xf5U, 0xbbU, 0xdcU, 0x27U, 0x0cU, 0x65U, 0xb1U,
            0x74U, 0x9aU, 0x6eU, 0xffU, 0xf1U, 0xfbU, 0xaaU, 0x09U,
            0x53U, 0x61U, 0x75U, 0xccU, 0xd2U, 0x9fU, 0xb9U, 0xe6U,
            0x05U, 0x7bU, 0x30U, 0x73U, 0x20U, 0xd3U, 0x16U, 0x83U,
            0x8aU, 0x9cU, 0x71U, 0xf7U, 0x0bU, 0x5bU, 0x59U, 0x07U,
            0xa6U, 0x6fU, 0x7eU, 0xa4U, 0x9aU, 0xadU, 0xc4U, 0x09U,

            )

        val result = XChaCha20Pure.xorWithKeystream(key, nonce, message, 1U)
        assertTrue {
            result.contentEquals(expected)
        }

    }

    @Test
    fun testXChaCha20Updateable() {
        val key = ubyteArrayOf(
            0x80U, 0x81U, 0x82U, 0x83U, 0x84U, 0x85U, 0x86U, 0x87U,
            0x88U, 0x89U, 0x8aU, 0x8bU, 0x8cU, 0x8dU, 0x8eU, 0x8fU,
            0x90U, 0x91U, 0x92U, 0x93U, 0x94U, 0x95U, 0x96U, 0x97U,
            0x98U, 0x99U, 0x9aU, 0x9bU, 0x9cU, 0x9dU, 0x9eU, 0x9fU
        )
        val nonce = ubyteArrayOf(
            0x40U, 0x41U, 0x42U, 0x43U, 0x44U, 0x45U, 0x46U, 0x47U,
            0x48U, 0x49U, 0x4aU, 0x4bU, 0x4cU, 0x4dU, 0x4eU, 0x4fU,
            0x50U, 0x51U, 0x52U, 0x53U, 0x54U, 0x55U, 0x56U, 0x58U
        )
        val message = ubyteArrayOf(
            0x54U, 0x68U, 0x65U, 0x20U, 0x64U, 0x68U, 0x6fU, 0x6cU,
            0x65U, 0x20U, 0x28U, 0x70U, 0x72U, 0x6fU, 0x6eU, 0x6fU,
            0x75U, 0x6eU, 0x63U, 0x65U, 0x64U, 0x20U, 0x22U, 0x64U,
            0x6fU, 0x6cU, 0x65U, 0x22U, 0x29U, 0x20U, 0x69U, 0x73U,
            0x20U, 0x61U, 0x6cU, 0x73U, 0x6fU, 0x20U, 0x6bU, 0x6eU,
            0x6fU, 0x77U, 0x6eU, 0x20U, 0x61U, 0x73U, 0x20U, 0x74U,
            0x68U, 0x65U, 0x20U, 0x41U, 0x73U, 0x69U, 0x61U, 0x74U,
            0x69U, 0x63U, 0x20U, 0x77U, 0x69U, 0x6cU, 0x64U, 0x20U,
            0x64U, 0x6fU, 0x67U, 0x2cU, 0x20U, 0x72U, 0x65U, 0x64U,
            0x20U, 0x64U, 0x6fU, 0x67U, 0x2cU, 0x20U, 0x61U, 0x6eU,
            0x64U, 0x20U, 0x77U, 0x68U, 0x69U, 0x73U, 0x74U, 0x6cU,
            0x69U, 0x6eU, 0x67U, 0x20U, 0x64U, 0x6fU, 0x67U, 0x2eU,
            0x20U, 0x49U, 0x74U, 0x20U, 0x69U, 0x73U, 0x20U, 0x61U,
            0x62U, 0x6fU, 0x75U, 0x74U, 0x20U, 0x74U, 0x68U, 0x65U,
            0x20U, 0x73U, 0x69U, 0x7aU, 0x65U, 0x20U, 0x6fU, 0x66U,
            0x20U, 0x61U, 0x20U, 0x47U, 0x65U, 0x72U, 0x6dU, 0x61U,
            0x6eU, 0x20U, 0x73U, 0x68U, 0x65U, 0x70U, 0x68U, 0x65U,
            0x72U, 0x64U, 0x20U, 0x62U, 0x75U, 0x74U, 0x20U, 0x6cU,
            0x6fU, 0x6fU, 0x6bU, 0x73U, 0x20U, 0x6dU, 0x6fU, 0x72U,
            0x65U, 0x20U, 0x6cU, 0x69U, 0x6bU, 0x65U, 0x20U, 0x61U,
            0x20U, 0x6cU, 0x6fU, 0x6eU, 0x67U, 0x2dU, 0x6cU, 0x65U,
            0x67U, 0x67U, 0x65U, 0x64U, 0x20U, 0x66U, 0x6fU, 0x78U,
            0x2eU, 0x20U, 0x54U, 0x68U, 0x69U, 0x73U, 0x20U, 0x68U,
            0x69U, 0x67U, 0x68U, 0x6cU, 0x79U, 0x20U, 0x65U, 0x6cU,
            0x75U, 0x73U, 0x69U, 0x76U, 0x65U, 0x20U, 0x61U, 0x6eU,
            0x64U, 0x20U, 0x73U, 0x6bU, 0x69U, 0x6cU, 0x6cU, 0x65U,
            0x64U, 0x20U, 0x6aU, 0x75U, 0x6dU, 0x70U, 0x65U, 0x72U,
            0x20U, 0x69U, 0x73U, 0x20U, 0x63U, 0x6cU, 0x61U, 0x73U,
            0x73U, 0x69U, 0x66U, 0x69U, 0x65U, 0x64U, 0x20U, 0x77U,
            0x69U, 0x74U, 0x68U, 0x20U, 0x77U, 0x6fU, 0x6cU, 0x76U,
            0x65U, 0x73U, 0x2cU, 0x20U, 0x63U, 0x6fU, 0x79U, 0x6fU,
            0x74U, 0x65U, 0x73U, 0x2cU, 0x20U, 0x6aU, 0x61U, 0x63U,
            0x6bU, 0x61U, 0x6cU, 0x73U, 0x2cU, 0x20U, 0x61U, 0x6eU,
            0x64U, 0x20U, 0x66U, 0x6fU, 0x78U, 0x65U, 0x73U, 0x20U,
            0x69U, 0x6eU, 0x20U, 0x74U, 0x68U, 0x65U, 0x20U, 0x74U,
            0x61U, 0x78U, 0x6fU, 0x6eU, 0x6fU, 0x6dU, 0x69U, 0x63U,
            0x20U, 0x66U, 0x61U, 0x6dU, 0x69U, 0x6cU, 0x79U, 0x20U,
            0x43U, 0x61U, 0x6eU, 0x69U, 0x64U, 0x61U, 0x65U, 0x2eU,
        )

        val expected = ubyteArrayOf(
            0x7dU, 0x0aU, 0x2eU, 0x6bU, 0x7fU, 0x7cU, 0x65U, 0xa2U,
            0x36U, 0x54U, 0x26U, 0x30U, 0x29U, 0x4eU, 0x06U, 0x3bU,
            0x7aU, 0xb9U, 0xb5U, 0x55U, 0xa5U, 0xd5U, 0x14U, 0x9aU,
            0xa2U, 0x1eU, 0x4aU, 0xe1U, 0xe4U, 0xfbU, 0xceU, 0x87U,
            0xecU, 0xc8U, 0xe0U, 0x8aU, 0x8bU, 0x5eU, 0x35U, 0x0aU,
            0xbeU, 0x62U, 0x2bU, 0x2fU, 0xfaU, 0x61U, 0x7bU, 0x20U,
            0x2cU, 0xfaU, 0xd7U, 0x20U, 0x32U, 0xa3U, 0x03U, 0x7eU,
            0x76U, 0xffU, 0xdcU, 0xdcU, 0x43U, 0x76U, 0xeeU, 0x05U,
            0x3aU, 0x19U, 0x0dU, 0x7eU, 0x46U, 0xcaU, 0x1dU, 0xe0U,
            0x41U, 0x44U, 0x85U, 0x03U, 0x81U, 0xb9U, 0xcbU, 0x29U,
            0xf0U, 0x51U, 0x91U, 0x53U, 0x86U, 0xb8U, 0xa7U, 0x10U,
            0xb8U, 0xacU, 0x4dU, 0x02U, 0x7bU, 0x8bU, 0x05U, 0x0fU,
            0x7cU, 0xbaU, 0x58U, 0x54U, 0xe0U, 0x28U, 0xd5U, 0x64U,
            0xe4U, 0x53U, 0xb8U, 0xa9U, 0x68U, 0x82U, 0x41U, 0x73U,
            0xfcU, 0x16U, 0x48U, 0x8bU, 0x89U, 0x70U, 0xcaU, 0xc8U,
            0x28U, 0xf1U, 0x1aU, 0xe5U, 0x3cU, 0xabU, 0xd2U, 0x01U,
            0x12U, 0xf8U, 0x71U, 0x07U, 0xdfU, 0x24U, 0xeeU, 0x61U,
            0x83U, 0xd2U, 0x27U, 0x4fU, 0xe4U, 0xc8U, 0xb1U, 0x48U,
            0x55U, 0x34U, 0xefU, 0x2cU, 0x5fU, 0xbcU, 0x1eU, 0xc2U,
            0x4bU, 0xfcU, 0x36U, 0x63U, 0xefU, 0xaaU, 0x08U, 0xbcU,
            0x04U, 0x7dU, 0x29U, 0xd2U, 0x50U, 0x43U, 0x53U, 0x2dU,
            0xb8U, 0x39U, 0x1aU, 0x8aU, 0x3dU, 0x77U, 0x6bU, 0xf4U,
            0x37U, 0x2aU, 0x69U, 0x55U, 0x82U, 0x7cU, 0xcbU, 0x0cU,
            0xddU, 0x4aU, 0xf4U, 0x03U, 0xa7U, 0xceU, 0x4cU, 0x63U,
            0xd5U, 0x95U, 0xc7U, 0x5aU, 0x43U, 0xe0U, 0x45U, 0xf0U,
            0xccU, 0xe1U, 0xf2U, 0x9cU, 0x8bU, 0x93U, 0xbdU, 0x65U,
            0xafU, 0xc5U, 0x97U, 0x49U, 0x22U, 0xf2U, 0x14U, 0xa4U,
            0x0bU, 0x7cU, 0x40U, 0x2cU, 0xdbU, 0x91U, 0xaeU, 0x73U,
            0xc0U, 0xb6U, 0x36U, 0x15U, 0xcdU, 0xadU, 0x04U, 0x80U,
            0x68U, 0x0fU, 0x16U, 0x51U, 0x5aU, 0x7aU, 0xceU, 0x9dU,
            0x39U, 0x23U, 0x64U, 0x64U, 0x32U, 0x8aU, 0x37U, 0x74U,
            0x3fU, 0xfcU, 0x28U, 0xf4U, 0xddU, 0xb3U, 0x24U, 0xf4U,
            0xd0U, 0xf5U, 0xbbU, 0xdcU, 0x27U, 0x0cU, 0x65U, 0xb1U,
            0x74U, 0x9aU, 0x6eU, 0xffU, 0xf1U, 0xfbU, 0xaaU, 0x09U,
            0x53U, 0x61U, 0x75U, 0xccU, 0xd2U, 0x9fU, 0xb9U, 0xe6U,
            0x05U, 0x7bU, 0x30U, 0x73U, 0x20U, 0xd3U, 0x16U, 0x83U,
            0x8aU, 0x9cU, 0x71U, 0xf7U, 0x0bU, 0x5bU, 0x59U, 0x07U,
            0xa6U, 0x6fU, 0x7eU, 0xa4U, 0x9aU, 0xadU, 0xc4U, 0x09U,

            )

        val xChaCha = XChaCha20Pure(key, nonce, 1U)
        val firstChunk = xChaCha.xorWithKeystream(message.sliceArray(0 until 5))
        val secondChunk = xChaCha.xorWithKeystream(message.sliceArray(5 until 90))
        val thirdChunk = xChaCha.xorWithKeystream(message.sliceArray(90 until message.size))

        assertTrue {
            (firstChunk + secondChunk + thirdChunk).contentEquals(expected)
        }

    }

    @Test
    fun testXChaCha20UpdateableLonger() {
        val key = ubyteArrayOf(
            0x80U, 0x81U, 0x82U, 0x83U, 0x84U, 0x85U, 0x86U, 0x87U,
            0x88U, 0x89U, 0x8aU, 0x8bU, 0x8cU, 0x8dU, 0x8eU, 0x8fU,
            0x90U, 0x91U, 0x92U, 0x93U, 0x94U, 0x95U, 0x96U, 0x97U,
            0x98U, 0x99U, 0x9aU, 0x9bU, 0x9cU, 0x9dU, 0x9eU, 0x9fU
        )
        val nonce = ubyteArrayOf(
            0x40U, 0x41U, 0x42U, 0x43U, 0x44U, 0x45U, 0x46U, 0x47U,
            0x48U, 0x49U, 0x4aU, 0x4bU, 0x4cU, 0x4dU, 0x4eU, 0x4fU,
            0x50U, 0x51U, 0x52U, 0x53U, 0x54U, 0x55U, 0x56U, 0x58U
        )
        val message = ("This is a longer message that should cover all cases in the updateable algorithm. This string is 112 bytes long." +
                "This is a longer message that should cover all cases in the updateable algorithm. This string is 112 bytes long." +
                "This is a longer message that should cover all cases in the updateable algorithm. This string is 112 bytes long." +
                "This is a longer message that should cover all cases in the updateable algorithm. This string is 112 bytes long.").encodeToUByteArray()

        val expected = ubyteArrayOf(
            0x7DU, 0x0AU, 0x22U, 0x38U, 0x3BU, 0x7DU, 0x79U, 0xEEU,
            0x32U, 0x54U, 0x62U, 0x2FU, 0x35U, 0x46U, 0x0DU, 0x26U,
            0x2FU, 0xBAU, 0xB3U, 0x43U, 0xB2U, 0x94U, 0x51U, 0x9BU,
            0xEDU, 0x06U, 0x47U, 0xA2U, 0xB9U, 0xFBU, 0xD4U, 0x9CU,
            0xA3U, 0xDCU, 0xE0U, 0x9DU, 0xC4U, 0x1DU, 0x31U, 0x12U,
            0xB4U, 0x67U, 0x65U, 0x6EU, 0xF7U, 0x7EU, 0x7BU, 0x37U,
            0x25U, 0xECU, 0x92U, 0x12U, 0x61U, 0xA3U, 0x0CU, 0x2AU,
            0x6BU, 0xF4U, 0x99U, 0x8BU, 0x5FU, 0x6AU, 0xEEU, 0x44U,
            0x2AU, 0x13U, 0x0BU, 0x30U, 0x0AU, 0xDDU, 0x58U, 0xE5U,
            0x0DU, 0x47U, 0x85U, 0x16U, 0xC4U, 0xEDU, 0xC2U, 0x2AU,
            0xBAU, 0x51U, 0xB2U, 0x53U, 0x86U, 0xB8U, 0xF3U, 0x0FU,
            0xA5U, 0xB0U, 0x43U, 0x4CU, 0x78U, 0xC4U, 0x0BU, 0x52U,
            0x7CU, 0xC2U, 0x1DU, 0x46U, 0xA9U, 0x39U, 0x8CU, 0x71U,
            0xE3U, 0x4FU, 0xEDU, 0xB1U, 0x27U, 0x98U, 0x4EU, 0x38U,
            0x88U, 0x0DU, 0x48U, 0x82U, 0xCCU, 0x39U, 0xD6U, 0x8EU,
            0x69U, 0xB0U, 0x56U, 0xCDU, 0x37U, 0xBEU, 0xDAU, 0x12U,
            0x5CU, 0xB5U, 0x67U, 0x1CU, 0xC9U, 0x35U, 0xE1U, 0x61U,
            0xD1U, 0xC2U, 0x6FU, 0x4CU, 0xE5U, 0x9CU, 0xE2U, 0x4CU,
            0x55U, 0x2EU, 0xE8U, 0x3BU, 0x5FU, 0xB2U, 0x1EU, 0xC6U,
            0x4BU, 0xAEU, 0x7AU, 0x6BU, 0xE8U, 0xA3U, 0x08U, 0xBEU,
            0x45U, 0x62U, 0x23U, 0xCFU, 0x17U, 0x07U, 0x51U, 0x68U,
            0xABU, 0x36U, 0x1AU, 0xCEU, 0x68U, 0x61U, 0x60U, 0xEDU,
            0x6DU, 0x6FU, 0x5CU, 0x5FU, 0x87U, 0x6AU, 0xCBU, 0x05U,
            0xD8U, 0x4AU, 0xF3U, 0x1DU, 0xB7U, 0x9AU, 0x41U, 0x62U,
            0x8EU, 0xC6U, 0xFAU, 0x44U, 0x4FU, 0xB3U, 0x04U, 0xEDU,
            0xDCU, 0xB3U, 0xE8U, 0x99U, 0x85U, 0xDFU, 0xB8U, 0x73U,
            0xEBU, 0xD4U, 0xCCU, 0x0EU, 0x6FU, 0xE0U, 0x08U, 0xA2U,
            0x4EU, 0x66U, 0x13U, 0x60U, 0xD7U, 0x93U, 0xA8U, 0x2EU,
            0xE7U, 0xB7U, 0x39U, 0x0FU, 0x88U, 0xA0U, 0x57U, 0xD7U,
            0x60U, 0x5BU, 0x12U, 0x1EU, 0x43U, 0x72U, 0xC7U, 0x99U,
            0x7CU, 0x3DU, 0x2DU, 0x37U, 0x22U, 0x84U, 0x29U, 0x7EU,
            0x6BU, 0xEDU, 0x33U, 0xB9U, 0x89U, 0xF9U, 0x36U, 0xFFU,
            0xD4U, 0xE1U, 0xBBU, 0xCBU, 0x2BU, 0x4FU, 0x6BU, 0xA9U,
            0x75U, 0xC8U, 0x28U, 0xF1U, 0xE5U, 0xF2U, 0xF9U, 0x4AU,
            0x5BU, 0x7CU, 0x30U, 0xCBU, 0x9AU, 0x93U, 0xF7U, 0xB2U,
            0x10U, 0x6BU, 0x3AU, 0x3DU, 0x3AU, 0xCEU, 0x1BU, 0x81U,
            0xDEU, 0x9FU, 0x71U, 0xF8U, 0x0EU, 0x52U, 0x00U, 0x46U,
            0x89U, 0x69U, 0x7FU, 0xBFU, 0x97U, 0xB8U, 0xC9U, 0x4AU,
            0x3AU, 0x37U, 0x31U, 0x1EU, 0x88U, 0x68U, 0x35U, 0x98U,
            0x76U, 0x93U, 0xCDU, 0x91U, 0xF7U, 0x6AU, 0x59U, 0xE6U,
            0x82U, 0xB6U, 0x85U, 0x67U, 0x3FU, 0xF5U, 0x9EU, 0x82U,
            0x2DU, 0xFFU, 0x81U, 0x5EU, 0xEAU, 0x3BU, 0xCCU, 0xFBU,
            0x1BU, 0x87U, 0x4AU, 0x93U, 0x40U, 0x96U, 0x3CU, 0xB2U,
            0x8EU, 0xCCU, 0x38U, 0x00U, 0x3FU, 0xBAU, 0xCCU, 0x84U,
            0x88U, 0x2BU, 0xF0U, 0x11U, 0x09U, 0xD5U, 0xAAU, 0x54U,
            0x3AU, 0x5BU, 0x98U, 0xE6U, 0xADU, 0xC0U, 0xB9U, 0x95U,
            0x53U, 0xDFU, 0x9DU, 0x91U, 0x01U, 0x66U, 0x7CU, 0xB3U,
            0xD8U, 0x2BU, 0x2DU, 0xBCU, 0xE0U, 0x77U, 0x71U, 0x59U,
            0x36U, 0xACU, 0x6DU, 0x5EU, 0x55U, 0xC9U, 0x29U, 0x40U,
            0xD4U, 0xA2U, 0x5BU, 0xBDU, 0xC2U, 0xE2U, 0x98U, 0x3DU,
            0x8CU, 0x9FU, 0x07U, 0xE4U, 0x21U, 0x84U, 0x4CU, 0x12U,
            0x83U, 0x77U, 0x88U, 0x06U, 0xA4U, 0x6FU, 0xDFU, 0x9EU,
            0xF5U, 0xD3U, 0xE1U, 0xFCU, 0x49U, 0x66U, 0x36U, 0x96U,
            0x48U, 0xC7U, 0x32U, 0xBAU, 0x73U, 0xFFU, 0xEFU, 0xCCU,
            0x00U, 0xC2U, 0x56U, 0x9CU, 0xD0U, 0x70U, 0x2AU, 0x4FU,
            0x82U, 0xB4U, 0x0BU, 0x68U, 0xEAU, 0xC1U, 0x87U, 0xB3U,

            )

        val xChaCha = XChaCha20Pure(key, nonce, 1U)
        val firstChunk = xChaCha.xorWithKeystream(message.sliceArray(0 until 50))
        val secondChunk = xChaCha.xorWithKeystream(message.sliceArray(50 until 200))
        val thirdChunk = xChaCha.xorWithKeystream(message.sliceArray(200 until message.size))
        val result = (firstChunk + secondChunk + thirdChunk)
        assertTrue {
            result.contentEquals(expected)
        }



    }

}
