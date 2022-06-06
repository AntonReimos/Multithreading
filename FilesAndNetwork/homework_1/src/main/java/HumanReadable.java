public class HumanReadable {
    public static String humanReadable(long size) {
        String readableSize = "";
        char[] types = {'b', 'k', 'M', 'G'};
        for (int i = 0; i < types.length; i++) {
            double localSize;
            localSize = Math.round (size / Math.pow(1024, i));
            if (localSize < 1024) {
                readableSize = localSize + " " + types[i];
                break;
            } else {
                continue;
            }
        }
        return readableSize;
    }
}
