package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "Solcoin";
    public static final String coinTicker = "SOL";
    public static final String coinURIScheme = "solcoin";
    public static final String cryptsyMarketId = "";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START = "5";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[N]";
    public static final String PATTERN_PRIVATE_KEY_START_TESTNET = "9";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED_TESTNET = "c";

    public static String lowerCaseCoinName() { return coinName.toLowerCase(); }

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.solcoin.net/";    //Solcoin Abe
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //Abe path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //Abe path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //Abe path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "8YULQic1dwHkshBrhEq2takUuncFW9NVKZ";  //HashEngineering donation DGC address

    public static final String UNSPENT_API_URL = "";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Blockr;

    enum CoinHash {
        SHA256,
        scrypt,
    };
    public static final CoinHash coinPOWHash = CoinHash.scrypt;

    public static boolean checkpointFileSupport = true;
    public static int checkpointDaysBack = 21;
    //Original Values
    public static final int TARGET_TIMESPAN = (int)(11304);  // hell if I know: https://github.com/solcoin-project/solcoin/blob/master/src/config.h
    public static final int TARGET_SPACING = (int)(188);  // 188 seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //60 blocks

    private static int nDifficultySwitchHeight = 15000;



    public static final int getInterval(int height, boolean testNet) {
        return INTERVAL;    //60
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;    //60

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
        return TARGET_TIMESPAN;  //11304
    }
    
    public static int spendableCoinbaseDepth = 72; //main.h: static const int COINBASE_MATURITY
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(696342000).multiply(Utils.COIN);                 //main.h:  MAX_MONEY
    //public static final String MAX_MONEY_STRING = "200000000";     //main.h:  MAX_MONEY

    public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(20000);   // MIN_TX_FEE
    public static final BigInteger DUST_LIMIT = BigInteger.valueOf(10000); //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70002;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 209;        //version.h MIN_PROTO_VERSION - eliminate 60001 which are on the wrong fork

    public static final int BLOCK_CURRENTVERSION = 1;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client
    public static boolean supportsIrcDiscovery() {
        return PROTOCOL_VERSION <= 70002;
    }

    public static final int Port    = 24361;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 24363;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 18;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 5;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = false; //for backward compatibility with previous version of digitalcoin
    public static final long PacketMagic = 0xfec1badc;      // Solcoin packet magic value

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1d07ffff);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1388971085L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (32216616);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "579b9ba9d7e8de5fbcc9b76cc90324f4b5d2e95855eeb67ed23c85e73cc2e54d"; //main.cpp: hashGenesisBlock
    static public int genesisBlockValue = 1772;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "";   //"Söndag 5:e januari 2014 - MtGox registrerar för andra gången BTC på över $1000."
    static public String genesisTxOutBytes = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "solcoinseeds.z80.guru", // US
            "solcoinseeds.stolendata.net", // JAPAN
            "solcoinseeds.tru.io", // China

    };

    public static int minBroadcastConnections = 1;   //0 for default; we need more peers.

    //
    // TestNet - digitalcoin - not tested - does not exist
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 111;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xfcc1b7dc;      //0xfc, 0xc1, 0xb7, 0xdc
    public static final String testnetGenesisHash = "5e039e1ca1dbf128973bf6cff98169e40a1b194c3b91463ab74956f413b2f9c8";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 999999L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (99999);                         //main.cpp: LoadBlockIndex





    public static final boolean usingNewDifficultyProtocol(int height)
    { return height >= nDifficultySwitchHeight;}
    
    //main.cpp GetBlockValue(height, fee)
    public static final BigInteger GetBlockReward(int height)
    {
        return Utils.toNanoCoins(1772, 27).shiftRight(height / subsidyDecreaseBlockCount);
    }

    public static int subsidyDecreaseBlockCount = 131072;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
          "not supported"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "040184710FA689AD5023690C80F3A49C8F13F8D45B8C857FBCBC8BC4A8E4D3EB4B10F4D4604FA08DCE601AAF0F470216FE1B51850B4ACF21B179C45070AC7B03A9";
    public static final String TESTNET_SATOSHI_KEY = "";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.solcoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.solcoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.solcoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put( 0, new Sha256Hash("65f69a4591090928f98478622058f614e5f3db42a16f1d99885c8ecad2ecbc9f"));
        checkpoints.put( 512, new Sha256Hash("2c5ad2a937958da366409db37d08cf9b75fe8695d4897d403e54dc078bb30b61"));
        checkpoints.put( 3141, new Sha256Hash("85dc531ed9c6c955a27b004d613c7f810f3b9d9c2fac9c4e6f160e4a727fba47"));
        checkpoints.put( 7368, new Sha256Hash("ec9b27bbdaf6abdc984cbc24f08519a31488e58f5ad90e791b4f0766b5418460"));
        checkpoints.put( 10000, new Sha256Hash("25a8e9c4fc3baca9c6b4200f7b34754845e7e3a3d25226ad0c371ecdfd5f236a"));
        checkpoints.put( 17600, new Sha256Hash("3a03d650a9b11dccdf38117652eeadbbecd016cb9895341c08456ddc885c7685"));
        checkpoints.put( 57023, new Sha256Hash("b8ccbc4bb9765ca2d6e7eea5bb6c7ffe3768a24dd2fb49319d217c408a725031"));
        checkpoints.put( 98996, new Sha256Hash("d1eeaa723bff270d1483424beace793a3487721e964697303562b24a25c69f4d"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "8RdkF3RQyEeXW1jXSv3wpZm1B32PANEQW4";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "NeyhUJ4JtD8SPcWbB4YGqLg6TuWh3i5GveAV27R7JiPfTBuSGEum";

}
