SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel
require recipes-kernel/linux/linux-dtb.inc

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/git"

BRANCH = "linux-4.2.y"

# Corresponds to tag v3.14.43
SRCREV = "f4ca8c1b9c4e24a693794badf09d3a8857c46a80"
PV = "4.2.1"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=${BRANCH}"

kernel_do_configure_prepend() {
	cp ${S}/arch/arm/configs/multi_v7_defconfig ${B}/.config
}

KERNEL_DEVICETREE = "zynq-zc702.dtb \
	sun4i-a10-cubieboard.dtb \
	ecx-2000.dtb \
	highbank.dtb \
	vexpress-v2p-ca9.dtb \
	vexpress-v2p-ca15-tc1.dtb \
	exynos4210-smdkv310.dtb"
