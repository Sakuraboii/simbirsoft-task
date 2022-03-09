package org.simbirsoft.dashboard.core.urls;

public interface Board {
    String NAME = "board";
    String BOARD = Root.root + NAME;

    interface COUNT{
        String NAME = "count";
        String COUNT = BOARD + "/" + NAME;
    }
}
