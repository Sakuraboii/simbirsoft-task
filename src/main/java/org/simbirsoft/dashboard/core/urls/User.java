package org.simbirsoft.dashboard.core.urls;

public interface User {
    String NAME = "user";
    String USER = Root.root + NAME;

    interface All{
        String NAME = "all";
        String ALL = USER + "/" + NAME;
    }

    interface Id{
        String NAME = "{id}";
        String FULL = USER + "/" + NAME;
    }
}
