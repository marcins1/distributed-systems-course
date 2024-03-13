package utils;

public class Constants {
    public static final int PORT = 10000;
    public static final int MULTICAST_PORT = 22345;
    public static final int BUFFER_SIZE = 4096;
    public static final String MULTICAST_ADDRESS = "230.0.0.3";
    public static final String HOST = "localhost";
    public static final String MESSAGE_SEPARATOR = "~";
    public static final String LEAVE_COMMAND = "/leave";
    public static final String INCORRECT_MESSAGE_COMMAND = "UNKNOWN";
    public static final String SETTING_NICKNAME_COMMAND = "/nick";
    public static final String SET_NICKNAME_COMMAND = "/nicksuccess";
    public static final String CHAT_MESSAGE_COMMAND = "/chat";
    public static final String UDP_CONNECT_COMMAND = "/udp";
    public static final String UDP_MESSAGE_COMMAND = "U";
    public static final String MULTICAST_MESSAGE_COMMAND = "M";
    public static final String DEFAULT_USERNAME = "Anonymous";
    public static final String SERVER_NAME = "SERVER";
    public static final String ASCII_ART = """
                                                                                
                                                                                ..;===+.
                                                                            .:=iiiiii=+=
                                                                         .=i))=;::+)i=+,
                                                                      ,=i);)I)))I):=i=;
                                                                   .=i==))))ii)))I:i++
                                                                 +)+))iiiiiiii))I=i+:'
                                            .,:;;++++++;:,.       )iii+:::;iii))+i='
                                         .:;++=iiiiiiiiii=++;.    =::,,,:::=i));=+'
                                       ,;+==ii)))))))))))ii==+;,      ,,,:=i))+=:
                                     ,;+=ii))))))IIIIII))))ii===;.    ,,:=i)=i+
                                    ;+=ii)))IIIIITIIIIII))))iiii=+,   ,:=));=,
                                  ,+=i))IIIIIITTTTTITIIIIII)))I)i=+,,:+i)=i+
                                 ,+i))IIIIIITTTTTTTTTTTTI))IIII))i=::i))i='
                                ,=i))IIIIITLLTTTTTTTTTTIITTTTIII)+;+i)+i`
                                =i))IIITTLTLTTTTTTTTTIITTLLTTTII+:i)ii:'
                               +i))IITTTLLLTTTTTTTTTTTTLLLTTTT+:i)))=,
                               =))ITTTTTTTTTTTLTTTTTTLLLLLLTi:=)IIiii;
                              .i)IIITTTTTTTTLTTTITLLLLLLLT);=)I)))))i;
                              :))IIITTTTTLTTTTTTLLHLLLLL);=)II)IIIIi=:
                              :i)IIITTTTTTTTTLLLHLLHLL)+=)II)ITTTI)i=
                              .i)IIITTTTITTLLLHHLLLL);=)II)ITTTTII)i+
                              =i)IIIIIITTLLLLLLHLL=:i)II)TTTTTTIII)i'
                            +i)i)))IITTLLLLLLLLT=:i)II)TTTTLTTIII)i;
                          +ii)i:)IITTLLTLLLLT=;+i)I)ITTTTLTTTII))i;
                         =;)i=:,=)ITTTTLTTI=:i))I)TTTLLLTTTTTII)i;
                       +i)ii::,  +)IIITI+:+i)I))TTTTLLTTTTTII))=,
                     :=;)i=:,,    ,i++::i))I)ITTTTTTTTTTIIII)=+'
                   .+ii)i=::,,   ,,::=i)))iIITTTTTTTTIIIII)=+
                  ,==)ii=;:,,,,:::=ii)i)iIIIITIIITIIII))i+:'
                 +=:))i==;:::;=iii)+)=  `:i)))IIIII)ii+'
               .+=:))iiiiiiii)))+ii;
              .+=;))iiiiii)));ii+
             .+=i:)))))))=+ii+
            .;==i+::::=)i=;
            ,+==iiiiii+,
            `+=+++;`""";
}
