import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution implements Comparable<Solution> {

    public final int major;
    public final Integer minor;
    public final Integer patch;

    public Solution(String ver) {
        final String[] parts = ver.split("\\.");
        this.major = Integer.parseInt(parts[0]);
        if (parts.length > 1) {
            this.minor = Integer.parseInt(parts[1]);
            if (parts.length > 2) {
                this.patch = Integer.parseInt(parts[2]);
            } else {
                this.patch = null;
            }
        } else {
            this.minor = null;
            this.patch = null;
        }
    }

    @Override
    public int compareTo(Solution right) {
        int diff = this.major - right.major;
        if (diff != 0) {
            return diff;
        }
        if (this.minor == null && right.minor == null) {
            return 0;
        }
        if (this.minor == null && right.minor != null) {
            return -1;
        }
        if (this.minor != null && right.minor == null) {
            return +1;
        }
        diff = this.minor - right.minor;
        if (diff != 0) {
            return diff;
        }
        if (this.patch == null && right.patch == null) {
            return 0;
        }
        if (this.patch == null && right.patch != null) {
            return -1;
        }
        if (this.patch != null && right.patch == null) {
            return +1;
        }
        diff = this.patch - right.patch;
        return diff;
    }

    @Override
    public String toString() {
        return String.format("%d.%d.%d", major, minor, patch);
    }

    public static void main(String[] args) {
        String l[] = { "1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0" };
        final List<Solution> Solutions = new ArrayList<>();
        for (int i = 0; i < l.length; i++)
            Solutions.add(new Solution(l[i]));
        Collections.sort(Solutions);
        int index = 0;
        for (Solution s : Solutions) {
            l[index] = Integer.toString(s.major);
            if (s.minor != null) {
                l[index] = l[index] + "." + Integer.toString(s.minor);
            }
            if (s.patch != null) {
                l[index] = l[index] + "." + Integer.toString(s.patch);
            }
            index++;
        }
        while (index > 0) {
            index--;
            System.out.println(l[index]);
        }
    }
}