package com.actigage.whitelabelingdemo.data.speakers;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.common.base.Objects;
import java.util.UUID;

/**
 * @author Venkata Pranav
 */
@Entity(tableName = "speakers")
public final class Speaker {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "entryid")
    private final String id;

    @Nullable
    @ColumnInfo(name = "title")
    private final String title;

    @Nullable
    @ColumnInfo(name = "description")
    private final String description;

    @Ignore
    public Speaker(@Nullable String title, @Nullable String description) {
        this(title, description, UUID.randomUUID().toString());
    }

    public Speaker(@Nullable String title, @Nullable String description, @NonNull String id) {
        this.title = title;
        this.description = description;
        this.id = id;
    }




    public boolean isEmpty() {
        return (title == null || "".equals(title)) &&
                (description == null || "".equals(description));
    }

    @NonNull
    public String getId() {
        return id;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speaker note = (Speaker) o;
        return Objects.equal(title, note.title) &&
                Objects.equal(description, note.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, title, description);
    }
}
