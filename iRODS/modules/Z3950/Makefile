#
#modules/z3950/Makefile
#

myModule=Z3950
ifndef buildDir
buildDir = $(CURDIR)/../..
endif

include $(buildDir)/config/config.mk
include $(buildDir)/config/platform.mk
include $(buildDir)/config/directories.mk
include $(buildDir)/config/common.mk


#
# Directories
#
MSObjDir =	$(modulesDir)/$(myModule)/microservices/obj
MSSrcDir =	$(modulesDir)/$(myModule)/microservices/src
MSIncDir =	$(modulesDir)/$(myModule)/microservices/include



#
# Source files
#
MYYAZ  = $(modulesDir)/$(myModule)/yaz


OBJECTS = $(MSObjDir)/z3950ClientMS.o
INCLUDE_FLAGS =	-I$(MSIncDir) -I$(MYYAZ)/include
LIBS =  -L$(MYYAZ)/src/.libs -lyaz 




#
# Compile and link flags
#
INCLUDES += $(INCLUDE_FLAGS) $(LIB_INCLUDES) $(SVR_INCLUDES) 
CFLAGS_OPTIONS := $(CFLAGS) $(MY_CFLAG)
CFLAGS = $(CFLAGS_OPTIONS) $(INCLUDES) $(MODULE_CFLAGS) 




.PHONY: all rules microservices server client clean
.PHONY: server_ldflags client_ldflags server_cflags client_cflags
.PHONY: print_cflags

# Build everything
all:	microservices
	@true

# List module's objects for inclusion in the clients
client_ldflags:
	@true

# List module's includes for inclusion in the clients
client_cflags:
	@true

# List module's objects for inclusion in the server
server_ldflags:
	@echo $(OBJECTS) $(LIBS)

# List module's includes for inclusion in the server
server_cflags:
	@echo $(INCLUDE_FLAGS)

# Build microservices
microservices:	print_cflags $(OBJECTS)
	@true

# Build client additions
client:
	@true

# Build server additions
server:
	@true

# Build rules
rules:
	@true

# Clean
clean:
	@echo "Clean $(myModule) module..."
	@rm -f $(OBJECTS)

# Show compile flags
print_cflags:
	@echo "Compile flags:"

#
# Compilation targets
#

$(OBJECTS): $(MSObjDir)/%.o: $(MSSrcDir)/%.c $(DEPEND)
		$(CC) -c $(CFLAGS) -o $@ $< 
		


#		@echo "Here is the cflag"
#		@echo $(CFLAGS)		
#		@echo "Here are the objects  " 
#		@echo $(OBJECTS)	    	
#		@echo "Here is the last command " 

