{ java ? "openjdk8" }:

let
  sources = import ./nix/sources.nix;
  pkgs = import sources.nixpkgs {};
in
pkgs.mkShell {
  buildInputs = [
    pkgs.jekyll
    pkgs.${java}
    pkgs.sbt
    pkgs.nodejs
  ];
}
