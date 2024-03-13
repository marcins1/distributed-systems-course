package server;

import java.net.InetAddress;

public record UDPClientHandler(InetAddress address, int port, String nickname) {}