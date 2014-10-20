package hashengineering.difficulty.SolcoinGravityWell;

import java.lang.UnsatisfiedLinkError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by HashEngineering on 3/7/14.
 *
 * Updated on 4/15/2014 for the Vegas Gravity Well (includes a fix for the KGW time warp exploit)
 *
 * Native implimentation requires three methods to be called
 *  - init  - before the loop
 *  - loop2 - for each iteration of the loop
 *  - close - at the end of the loop and it returns the calculated difficulty
 */
public class fgw {
    private static final Logger log = LoggerFactory.getLogger(fgw.class);
    private static boolean native_library_loaded = false;
    static {
        try {
            System.loadLibrary("fgw");
            native_library_loaded = true;
        }
        catch(NoSuchMethodError e)
        {
            //catches an error on 4.4.2; we don't know why this happens yet.
            log.info(e.getMessage());
        }
        catch(UnsatisfiedLinkError e)
        {
            //no need to do anything here, the native_library_loaded value will be false
            log.info(e.getMessage());
        }
        catch(Exception e)
        {

        }
    }
    public static boolean isNativeLibraryLoaded() { return native_library_loaded; }
    public static native byte[] KimotoGravityWell_close();

    public static native int KimotoGravityWell_init(long _TargetBlocksSpacingSeconds, long _PastBlocksMin, long _PastBlocksMax, double deviationDenominator, long _LatestBlockTime);
    //public static native int KimotoGravityWell_loop(int i, byte[] BlockReadingDiff, int BlockReadingHeight, long BlockReadingTime, long BlockLastSolvedTime);
    public static native int KimotoGravityWell_loop2(int i, long BlockReadingDiff, int BlockReadingHeight, long BlockReadingTime, long BlockLastSolvedTime);

    //todo::Refactor the entire algorithm here (native and hybrid)
}
