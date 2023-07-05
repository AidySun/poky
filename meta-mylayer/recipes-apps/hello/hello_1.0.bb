SUMMARY = "Simple Hello World Application"
DESCRIPTION = "A test application to demonstrate how to create a recipe \
              by directly compiling C files with BitBake."

# a category this package belong to
SECTION = "examples"
# this package is optional, lacking of it doesn't cause error
PRIORITY = "optional"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "\
    file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello-1.0.tar.gz"

# S = "${WORKDIR}"
# fix WARN_QA error
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
    ${CC} -c helloprint.c
    ${CC} -c hello.c
    ${CC} -o hello hello.o helloprint.o
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 hello ${D}${bindir}
}

