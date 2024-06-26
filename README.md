This repository packages the [nodex agent](https://github.com/nodecross/nodex) as a Yocto layer.

## Dependencies

- URI: git://git.openembedded.org/meta-openembedded
  - branch: mickledore
- URI: https://github.com/rust-embedded/meta-rust-bin.git
  - branch: master

## How to use

1. Move to your build directory.
2. Execute the add-layer command against the dependencies and this repository.
3. Set to use systemd.
4. Append the following line to `conf/local.conf`.
```
IMAGE_INSTALL:append = " nodex nodexsystemd"
```
5. Modify the contents of `/path/to/meta-nodex/recipes-nodex/nodex/nodex/network.json` to suit your environment.
