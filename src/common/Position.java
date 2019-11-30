package common;

import java.util.Objects;

public class Position {
    private int line;
    private int column;

    public Position(final int line, final int column) {
        this.line = line;
        this.column = column;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }
        final Position position = (Position) o;
        return line == position.line && column == position.column;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(line, column);
    }

    public final int getLine() {
        return line;
    }

    public final void setLine(final int line) {
        this.line = line;
    }

    public final int getColumn() {
        return column;
    }

    public final void setColumn(final int column) {
        this.column = column;
    }

    public final void setPosition(final int lin, final int col) {
        line = lin;
        column = col;
    }
}
