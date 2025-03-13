module example

go 1.22
toolchain go1.23.7

require (
	connectrpc.com/connect v1.16.1
	go.akshayshah.org/connectproto v0.6.0
	go.uber.org/automaxprocs v1.5.3
	golang.org/x/net v0.36.0
)

require (
	golang.org/x/text v0.22.0 // indirect
	google.golang.org/protobuf v1.33.0 // indirect
)

replace local => ./
