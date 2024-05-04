from google.protobuf.internal import enum_type_wrapper as _enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class CameraType(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = ()
    REGULAR: _ClassVar[CameraType]
    PTZ: _ClassVar[CameraType]
    NIGHT: _ClassVar[CameraType]

class SwitchType(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = ()
    TOGGLE: _ClassVar[SwitchType]
    NIGHT_MODE: _ClassVar[SwitchType]

class CameraResolution(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = ()
    RESOLUTION_480P: _ClassVar[CameraResolution]
    RESOLUTION_720P: _ClassVar[CameraResolution]
    RESOLUTION_1080P: _ClassVar[CameraResolution]
REGULAR: CameraType
PTZ: CameraType
NIGHT: CameraType
TOGGLE: SwitchType
NIGHT_MODE: SwitchType
RESOLUTION_480P: CameraResolution
RESOLUTION_720P: CameraResolution
RESOLUTION_1080P: CameraResolution

class SwitchRequest(_message.Message):
    __slots__ = ("camera_id", "switch_type", "value")
    CAMERA_ID_FIELD_NUMBER: _ClassVar[int]
    SWITCH_TYPE_FIELD_NUMBER: _ClassVar[int]
    VALUE_FIELD_NUMBER: _ClassVar[int]
    camera_id: str
    switch_type: SwitchType
    value: bool
    def __init__(self, camera_id: _Optional[str] = ..., switch_type: _Optional[_Union[SwitchType, str]] = ..., value: bool = ...) -> None: ...

class CameraResolutionRequest(_message.Message):
    __slots__ = ("camera_id", "resolution")
    CAMERA_ID_FIELD_NUMBER: _ClassVar[int]
    RESOLUTION_FIELD_NUMBER: _ClassVar[int]
    camera_id: str
    resolution: CameraResolution
    def __init__(self, camera_id: _Optional[str] = ..., resolution: _Optional[_Union[CameraResolution, str]] = ...) -> None: ...

class CameraRotateRequest(_message.Message):
    __slots__ = ("camera_id", "pan", "tilt")
    CAMERA_ID_FIELD_NUMBER: _ClassVar[int]
    PAN_FIELD_NUMBER: _ClassVar[int]
    TILT_FIELD_NUMBER: _ClassVar[int]
    camera_id: str
    pan: int
    tilt: int
    def __init__(self, camera_id: _Optional[str] = ..., pan: _Optional[int] = ..., tilt: _Optional[int] = ...) -> None: ...

class CameraZoomRequest(_message.Message):
    __slots__ = ("camera_id", "zoom")
    CAMERA_ID_FIELD_NUMBER: _ClassVar[int]
    ZOOM_FIELD_NUMBER: _ClassVar[int]
    camera_id: str
    zoom: int
    def __init__(self, camera_id: _Optional[str] = ..., zoom: _Optional[int] = ...) -> None: ...

class CameraResponse(_message.Message):
    __slots__ = ("message",)
    MESSAGE_FIELD_NUMBER: _ClassVar[int]
    message: str
    def __init__(self, message: _Optional[str] = ...) -> None: ...

class CameraInfoRequest(_message.Message):
    __slots__ = ("camera_id",)
    CAMERA_ID_FIELD_NUMBER: _ClassVar[int]
    camera_id: str
    def __init__(self, camera_id: _Optional[str] = ...) -> None: ...

class CameraInfoResponse(_message.Message):
    __slots__ = ("camera_id", "type", "is_on", "is_night_mode_on", "resolution", "pan", "tilt", "zoom")
    CAMERA_ID_FIELD_NUMBER: _ClassVar[int]
    TYPE_FIELD_NUMBER: _ClassVar[int]
    IS_ON_FIELD_NUMBER: _ClassVar[int]
    IS_NIGHT_MODE_ON_FIELD_NUMBER: _ClassVar[int]
    RESOLUTION_FIELD_NUMBER: _ClassVar[int]
    PAN_FIELD_NUMBER: _ClassVar[int]
    TILT_FIELD_NUMBER: _ClassVar[int]
    ZOOM_FIELD_NUMBER: _ClassVar[int]
    camera_id: str
    type: CameraType
    is_on: bool
    is_night_mode_on: bool
    resolution: CameraResolution
    pan: int
    tilt: int
    zoom: int
    def __init__(self, camera_id: _Optional[str] = ..., type: _Optional[_Union[CameraType, str]] = ..., is_on: bool = ..., is_night_mode_on: bool = ..., resolution: _Optional[_Union[CameraResolution, str]] = ..., pan: _Optional[int] = ..., tilt: _Optional[int] = ..., zoom: _Optional[int] = ...) -> None: ...
