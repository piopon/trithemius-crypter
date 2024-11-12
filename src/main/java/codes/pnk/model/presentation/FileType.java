package codes.pnk.model.presentation;

public enum FileType {
    TEXT("TEXT files (*.txt)", "*.txt"),
    JPEG("JPEG files (*.jpg)", "*.jpg");

    private final String description;
    private final String[] extension;

    private FileType(final String description, final String... extension) {
        this.description = description;
        this.extension = extension;
    }

    public String getDescription() {
        return this.description;
    }

    public String[] getExtension() {
        return this.extension;
    }
}
