package me.hsgamer.commonmark.bbcode;

public interface BBCodeNodeRendererContext {
    String escapeUrl(String url);

    BBCodeWriter getWriter();

    String getSoftBreak();
}
