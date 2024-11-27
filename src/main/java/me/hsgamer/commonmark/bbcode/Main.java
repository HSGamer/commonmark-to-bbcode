package me.hsgamer.commonmark.bbcode;

import org.commonmark.internal.util.Escaping;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

public class Main {
    public static void main(String[] args) {
        Node node = Parser.builder().build().parse("""
                # HSCore
                
                ![Maven Central](https://img.shields.io/maven-central/v/me.hsgamer/hscore) ![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/me.hsgamer/hscore?color=green&label=snapshot&server=https%3A%2F%2Frepo.codemc.io) [![Build Status](https://ci.codemc.io/job/HSGamer/job/HSCore/badge/icon)](https://ci.codemc.io/job/HSGamer/job/HSCore/) [![Javadocs](https://img.shields.io/badge/javadocs-link-green)](https://hsgamer.github.io/HSCore/) [![Discord](https://img.shields.io/discord/660795353037144064)](http://discord.hsgamer.me/)
                
                ## Info
                
                * This is a collection of common code used in my personal projects.
                * I created this core because I am too lazy to change/fix/update the same code over and over again.
                * This also includes some simple/useful/complex/dumb/... features used mainly in my projects.
                
                ## Affiliated Libraries
                
                Part of the code in this repository was moved to the following repositories:
                
                - [MineLib](https://github.com/ProjectUnified/MineLib)
                
                ## Add as a dependency
                
                ### Maven
                
                ```xml
                
                <dependencies>
                  <dependency>
                    <groupId>me.hsgamer</groupId>
                    <artifactId>hscore-MODULE</artifactId>
                    <version>VERSION</version>
                  </dependency>
                </dependencies>
                ```
                
                ### Gradle
                
                ```groovy
                dependencies {
                  implementation 'me.hsgamer:hscore-MODULE:VERSION'
                }
                ```
                """);
        StringBuilder builder = new StringBuilder();
        BBCodeNodeRendererContext context = new BBCodeNodeRendererContext() {
            @Override
            public String escapeUrl(String url) {
                return Escaping.escapeHtml(url);
            }

            @Override
            public BBCodeWriter getWriter() {
                return new BBCodeWriter(builder);
            }

            @Override
            public String getSoftBreak() {
                return "\n";
            }
        };
        CodeBBCodeNodeRenderer renderer = new CodeBBCodeNodeRenderer(context);
        node.accept(renderer);
        System.out.println(builder);
    }
}
