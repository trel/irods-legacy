myTestRule {
#Input parameters are:
#  inRequestPath - the string sent to the remote database object
#  inFileMode - the cache file creation mode
#  inFileFlags - the access modes for the cache file
#  inCacheFileName - the full path of the cache file
#No output parameters
#Output is the name of the file that was created
  msiSplitPath(*Path, *Coll, *File);
  msiobjget_dbo(*Request, *Mode, *Flags, *Path);
  msiExecStrCondQuery("SELECT DATA_NAME where DATA_NAME = '*File' and COLL_NAME = '*Coll'",*GenQOut);
  foreach(*GenQOut) {
    msiGetValByKey(*GenQOut, "DATA_NAME", *Filestore);
    writeLine("stdout","Created file *Filestore");
  }
}
INPUT *Request ="//dbo:dbr2:/tempZone/home/rods/dbotest/lt.pg", *Mode = "w", *Flags = "O_RDWR", *Path = "/tempZone/home/rods/sub1/rodsfile"
OUTPUT ruleExecOut